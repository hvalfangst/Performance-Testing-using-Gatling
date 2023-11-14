package hvalfangst.heroes.model.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object HeroesTable : Table("heroes") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    val hitPoints = integer("hit_points")
    val dateOfBirth = date("date_of_birth")
    val race = varchar("race", 255)
    val characterClass = varchar("hero_class", 255)
    val level = integer("level")
    val alignment = varchar("alignment", 255)
    val strength = integer("strength")
    val dexterity = integer("dexterity")
    val constitution = integer("constitution")
    val intelligence = integer("intelligence")
    val wisdom = integer("wisdom")
    val charisma = integer("charisma")
    val speed = integer("speed")
    val initiative = integer("initiative")
    val proficiencyBonus = integer("proficiency_bonus")
    val savingThrows = varchar("saving_throws", 255)
    val skills = varchar("skills", 255)
    val languages = varchar("languages", 255)
    val features = varchar("features", 255)
    val equipment = varchar("equipment", 255)
    val background = varchar("background", 255)
    val armorClass = integer("armor_class")
    val attack = integer("attack")
    val damage = varchar("damage", 255)
}
