package hero

import (
	"context"
	"errors"
	"github.com/jackc/pgx/v4"
	"github.com/jackc/pgx/v4/pgxpool"
	"hvalfangst/golang-fasthttp-pgx/src/model"
	"log"
)

func GetHeroById(ctx context.Context, conn *pgxpool.Conn, heroId int64) (*model.Heroes, error) {
	hero := &model.Heroes{}

	err := conn.QueryRow(
		ctx,
		"SELECT id, name, hit_points, date_of_birth, race, hero_class, level, alignment, "+
			"strength, dexterity, constitution, intelligence, wisdom, charisma, armor_class, "+
			"speed, initiative, proficiency_bonus, saving_throws, skills, languages, features, "+
			"equipment, background, attack, damage FROM heroes WHERE id = $1",
		heroId,
	).Scan(
		&hero.ID, &hero.Name, &hero.HitPoints, &hero.DateOfBirth, &hero.Race, &hero.HeroClass,
		&hero.Level, &hero.Alignment, &hero.Strength, &hero.Dexterity, &hero.Constitution,
		&hero.Intelligence, &hero.Wisdom, &hero.Charisma, &hero.ArmorClass, &hero.Speed,
		&hero.Initiative, &hero.ProficiencyBonus, &hero.SavingThrows, &hero.Skills,
		&hero.Languages, &hero.Features, &hero.Equipment, &hero.Background, &hero.Attack,
		&hero.Damage,
	)

	if errors.Is(err, pgx.ErrNoRows) {
		log.Printf("Hero with ID %d not found", heroId)
		return nil, nil // Return nil and no error for not found
	} else if err != nil {
		log.Printf("Error retrieving hero by ID: %v", err)
		return nil, err
	}

	// If no error occurred, return the hero.
	return hero, nil
}
