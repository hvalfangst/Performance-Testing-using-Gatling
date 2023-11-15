package handler

import (
	"encoding/json"
	"github.com/jackc/pgx/v4/pgxpool"
	"github.com/valyala/fasthttp"
	HeroRepository "hvalfangst/golang-fasthttp-pgx/src/repository/hero"
	"strconv"
)

func incrementLevelCounter() int {
	levelCounter++
	return levelCounter
}

var levelCounter = 0

func GetHeroById(pool *pgxpool.Pool) fasthttp.RequestHandler {
	return func(ctx *fasthttp.RequestCtx) {

		id, err := strconv.ParseInt(ctx.UserValue("id").(string), 10, 64)
		if err != nil {
			ctx.SetStatusCode(fasthttp.StatusBadRequest)
			_, err := ctx.WriteString(`{"error": "Invalid hero ID"}`)
			if err != nil {
				return
			}
			return
		}

		// Acquire a connection from the pool
		conn, err := pool.Acquire(ctx)
		if err != nil {
			ctx.SetStatusCode(fasthttp.StatusInternalServerError)
			ctx.SetBodyString(`{"error": "Failed to acquire database connection"}`)
			return
		}
		defer conn.Release()

		// Query hero by ID
		hero, err := HeroRepository.GetHeroById(ctx, conn, id)
		if err != nil {
			ctx.SetStatusCode(fasthttp.StatusNotFound)
			ctx.SetBodyString(`{"error": "Hero doesn't exist"}`)
			return
		}

		hero.Level = incrementLevelCounter()

		// Serialize the hero object to JSON
		heroJSON, err := json.Marshal(hero)
		if err != nil {
			ctx.SetStatusCode(fasthttp.StatusInternalServerError)
			ctx.SetBodyString(`{"error": "Internal Server Error"}`)
			return
		}

		ctx.SetContentType("application/json")
		ctx.SetBody(heroJSON)
	}
}
