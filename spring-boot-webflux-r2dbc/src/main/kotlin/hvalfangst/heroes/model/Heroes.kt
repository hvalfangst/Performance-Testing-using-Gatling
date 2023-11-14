package hvalfangst.heroes.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import org.springframework.data.annotation.Id
import java.io.Serializable
import java.time.LocalDate

@Entity
@Table(name = "heroes")
data class Heroes(

    @Column(name = "name")
    @JsonProperty("name")
    val name: String,

    @Column(name = "hit_points")
    @JsonProperty("hit_points")
    val hitPoints: Int,

    @Column(name = "date_of_birth")
    @JsonProperty("date_of_birth")
    val dateOfBirth: LocalDate,

    @Column(name = "race")
    @JsonProperty("race")
    val race: String,

    @Column(name = "hero_class")
    @JsonProperty("hero_class")
    val heroClass: String,

    @Column(name = "level")
    @JsonProperty("level")
    var level: Int,

    @Column(name = "alignment")
    @JsonProperty("alignment")
    val alignment: String,

    @Column(name = "strength")
    @JsonProperty("strength")
    val strength: Int,

    @Column(name = "dexterity")
    @JsonProperty("dexterity")
    val dexterity: Int,

    @Column(name = "constitution")
    @JsonProperty("constitution")
    val constitution: Int,

    @Column(name = "intelligence")
    @JsonProperty("intelligence")
    val intelligence: Int,

    @Column(name = "wisdom")
    @JsonProperty("wisdom")
    val wisdom: Int,

    @Column(name = "charisma")
    @JsonProperty("charisma")
    val charisma: Int,

    @Column(name = "armor_class")
    @JsonProperty("armor_class")
    val armorClass: Int,

    @Column(name = "speed")
    @JsonProperty("speed")
    val speed: Int,

    @Column(name = "initiative")
    @JsonProperty("initiative")
    val initiative: Int,

    @Column(name = "proficiency_bonus")
    @JsonProperty("proficiency_bonus")
    val proficiencyBonus: Int,

    @Column(name = "saving_throws")
    @JsonProperty("saving_throws")
    val savingThrows: String,

    @Column(name = "skills")
    @JsonProperty("skills")
    val skills: String,

    @Column(name = "languages")
    @JsonProperty("languages")
    val languages: String,

    @Column(name = "features")
    @JsonProperty("features")
    val features: String,

    @Column(name = "equipment")
    @JsonProperty("equipment")
    val equipment: String,

    @Column(name = "background")
    @JsonProperty("background")
    val background: String,

    @Column(name = "attack")
    @JsonProperty("attack")
    val attack: Int,

    @Column(name = "damage")
    @JsonProperty("damage")
    val damage: String,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    val id: Long? = null
) : Serializable
