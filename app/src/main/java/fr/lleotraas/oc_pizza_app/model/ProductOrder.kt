package fr.lleotraas.oc_pizza_app.model

class ProductOrder(
    val productName: String,
    val orderId: Int,
    val vatRate: Float,
    val quantity: Int,
    val unitPriceDf: Float
)