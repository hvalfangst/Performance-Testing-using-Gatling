package hvalfangst.heroes.repository

import hvalfangst.heroes.model.Heroes
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface HeroRepository: R2dbcRepository<Heroes, Long>

