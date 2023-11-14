package hvalfangst.heroes.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class Hero(
    val id: Int,
    val name: String,
    @JsonProperty("hit_points") val hitPoints: Int,
    @JsonProperty("date_of_birth") val dateOfBirth: LocalDate,
    val race: String,
    @JsonProperty("character_class") val characterClass: String,
    val level: Int,
    val alignment: String,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    @JsonProperty("armor_class") val armorClass: Int,
    val speed: Int,
    val initiative: Int,
    @JsonProperty("proficiency_bonus") val proficiencyBonus: Int,
    @JsonProperty("saving_throws") val savingThrows: String,
    val skills: String,
    val languages: String,
    val features: String,
    val equipment: String,
    val background: String,
    val attack: Int,
    val damage: String
)