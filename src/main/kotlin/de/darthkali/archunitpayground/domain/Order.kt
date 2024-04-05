package de.darthkali.archunitpayground.domain

data class Order(
    val pizzen: List<Pizza>,
    val gesamtpreis: Float
)
