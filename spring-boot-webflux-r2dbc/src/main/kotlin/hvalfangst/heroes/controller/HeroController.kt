package hvalfangst.heroes.controller

import hvalfangst.heroes.model.Heroes
import hvalfangst.heroes.repository.HeroRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/heroes")
class HeroController(private val heroRepository: HeroRepository) {

    private var levelCounter = 0

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Mono<Heroes> {
        return heroRepository.findById(id)
            .map { hero ->
                hero.level = ++levelCounter
                hero
            }
    }

}
