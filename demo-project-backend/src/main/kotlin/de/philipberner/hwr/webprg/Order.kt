package de.philipberner.hwr.webprg

data class Order(
    val deliveryInformation: DeliveryInformation,
    val items: List<OrderElement>
)
