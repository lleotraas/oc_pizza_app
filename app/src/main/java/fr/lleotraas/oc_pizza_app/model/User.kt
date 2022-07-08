package fr.lleotraas.oc_pizza_app.model

class User(
    val id: Int,
    val accountName: String,
    val accountPassword: String,
    val firstname: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val role: String
)