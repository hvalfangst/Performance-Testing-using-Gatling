package hero

import (
	"github.com/uptrace/bun"
	"hvalfangst/golang-gin-api-with-bun/src/model"
	"log"
	"context"
	"time"
)

func GetHeroById(db *bun.DB, heroID int64) (*model.Heroes, error) {
	heroes := &model.Heroes{}

	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
	defer cancel()

	err := db.NewSelect().Model(heroes).Where("id = ?", heroID).Scan(ctx)

	if err != nil {
		log.Printf("Error retrieving hero by ID: %v", err)
		return nil, err
	}

	return heroes, nil
}
