package hvalfangst.heroes.controller

import hvalfangst.heroes.model.Hero
import hvalfangst.heroes.repository.HeroRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/heroes")
class HeroesController(private val heroRepository: HeroRepository) {

    private var levelCounter = 0

    @GetMapping("/{id}")
    fun getHero(@PathVariable id: Int): ResponseEntity<Hero> {
        val hero = heroRepository.getHeroById(id)
        levelCounter++

        val modifiedHero = hero?.copy(level = levelCounter)
        return ResponseEntity.status(HttpStatus.OK).body(modifiedHero)
    }
}
