package de.philipberner.hwr.webprg

data class DeliveryInformation(
    val name: String,
    val firstName: String,
    val street: String,
    val houseNumber: String,
    val postcode: String,
    val note: String
)
