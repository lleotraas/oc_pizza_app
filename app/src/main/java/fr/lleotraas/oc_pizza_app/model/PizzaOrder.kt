package fr.lleotraas.oc_pizza_app.model

class PizzaOrder(
    val id: Int,
    val userId: Int,
    val restaurantName: String,
    val creationDate: String,
    val deliveryHour: String,
    val deliveryState: String,
    val isPaid: Boolean,
    val isDelivery: Boolean,
    val amount: Float
)