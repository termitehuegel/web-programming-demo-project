package de.philipberner.hwr.webprg

data class Dish(
    val classification: DishClassification,
    val name: String,
    val description: String,
    val price: Int // euro cent
)
