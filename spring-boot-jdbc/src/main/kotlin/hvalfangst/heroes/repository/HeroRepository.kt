package hvalfangst.heroes.repository

import hvalfangst.heroes.model.Hero
import hvalfangst.heroes.model.tables.HeroesTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class HeroRepository {

    fun getHeroById(id: Int): Hero? = transaction {
        HeroesTable.select { HeroesTable.id eq id }.singleOrNull()?.let { toHero(it) }
    }

    private fun toHero(row: ResultRow): Hero {
        return Hero(
            id = row[HeroesTable.id],
            name = row[HeroesTable.name],
            hitPoints = row[HeroesTable.hitPoints],
            dateOfBirth = row[HeroesTable.dateOfBirth],
            race = row[HeroesTable.race],
            characterClass = row[HeroesTable.characterClass],
            level = row[HeroesTable.level],
            alignment = row[HeroesTable.alignment],
            strength = row[HeroesTable.strength],
            dexterity = row[HeroesTable.dexterity],
            constitution = row[HeroesTable.constitution],
            intelligence = row[HeroesTable.intelligence],
            wisdom = row[HeroesTable.wisdom],
            charisma = row[HeroesTable.charisma],
            armorClass = row[HeroesTable.armorClass],
            speed = row[HeroesTable.speed],
            initiative = row[HeroesTable.initiative],
            proficiencyBonus = row[HeroesTable.proficiencyBonus],
            savingThrows = row[HeroesTable.savingThrows],
            skills = row[HeroesTable.skills],
            languages = row[HeroesTable.languages],
            features = row[HeroesTable.features],
            equipment = row[HeroesTable.equipment],
            background = row[HeroesTable.background],
            attack = row[HeroesTable.attack],
            damage = row[HeroesTable.damage]
        )
    }
}