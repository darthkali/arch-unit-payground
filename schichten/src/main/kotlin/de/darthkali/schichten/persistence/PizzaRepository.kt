package de.darthkali.schichten.persistence

import de.darthkali.schichten.controller.OrderController
import org.springframework.stereotype.Repository

@Repository
class PizzaRepository {

    val order = OrderController()
}