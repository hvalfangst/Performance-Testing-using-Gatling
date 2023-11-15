package route

import (
	"github.com/gin-gonic/gin"
	"github.com/uptrace/bun"
	HeroesHandler "hvalfangst/golang-gin-api-with-bun/src/handler"
)

func ConfigureRoute(r *gin.Engine, db *bun.DB) {
	r.GET("/heroes/:id", HeroesHandler.GetHeroById(db))
}
