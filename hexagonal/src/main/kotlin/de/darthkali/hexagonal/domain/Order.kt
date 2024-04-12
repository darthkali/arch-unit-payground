package de.darthkali.hexagonal.domain

data class Order(
    val pizzen: List<de.darthkali.hexagonal.domain.Pizza>,
    val gesamtpreis: Float
)
