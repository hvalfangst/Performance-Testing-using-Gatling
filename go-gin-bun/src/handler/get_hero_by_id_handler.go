package handler

import (
	"github.com/gin-gonic/gin"
	"github.com/uptrace/bun"
	HeroesRepository "hvalfangst/golang-gin-api-with-bun/src/repository/hero"
	"strconv"
	"log"
)

func incrementLevelCounter() int {
	levelCounter++
	return levelCounter
}

var levelCounter = 0

func GetHeroById(db *bun.DB) gin.HandlerFunc {
	return func(c *gin.Context) {

		id, err := strconv.ParseInt(c.Param("id"), 10, 64)
		if err != nil {
			c.JSON(400, gin.H{"error": "Invalid Hero ID"})
			return
		}

		hero, err := HeroesRepository.GetHeroById(db, id)
		if err != nil {
			log.Printf("Error: %v", err)
			c.JSON(404, gin.H{"error": "Hero doesn't exist"})
			return
		}

		hero.Level = incrementLevelCounter()
		c.JSON(200, gin.H{"hero": hero})
	}
}
