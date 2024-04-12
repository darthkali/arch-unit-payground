package de.darthkali.hexagonal.domain

data class Pizza(
    val name: String,
    val preis: Float,
    val zutaten: List<String>
)
