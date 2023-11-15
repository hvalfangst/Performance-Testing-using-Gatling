package model

import "time"

type Heroes struct {
	ID              int64     `json:"id"`
	Name            string    `json:"name"`
	HitPoints       int       `json:"hit_points"`
	DateOfBirth     time.Time `json:"date_of_birth"`
	Race            string    `json:"race"`
	HeroClass       string    `json:"hero_class"`
	Level           int       `json:"level"`
	Alignment       string    `json:"alignment"`
	Strength        int       `json:"strength"`
	Dexterity       int       `json:"dexterity"`
	Constitution    int       `json:"constitution"`
	Intelligence    int       `json:"intelligence"`
	Wisdom          int       `json:"wisdom"`
	Charisma        int       `json:"charisma"`
	ArmorClass      int       `json:"armor_class"`
	Speed           int       `json:"speed"`
	Initiative      int       `json:"initiative"`
	ProficiencyBonus int      `json:"proficiency_bonus"`
	SavingThrows    string    `json:"saving_throws"`
	Skills          string    `json:"skills"`
	Languages       string    `json:"languages"`
	Features        string    `json:"features"`
	Equipment       string    `json:"equipment"`
	Background      string    `json:"background"`
	Attack          int       `json:"attack"`
	Damage          string    `json:"damage"`
	_            struct{}  `pg:"_schema:heroes"`
}
