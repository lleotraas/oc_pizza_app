package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.Pizza
import retrofit2.http.GET
import retrofit2.http.Path

interface PizzaApi {

    @GET("/pizzas")
    suspend fun getAllPizza(): List<Pizza>

    @GET("/pizza/id={name}")
    suspend fun getPizza(
        @Path("name") name: String
    ): Pizza

    @GET("/add/pizza/id={name}/recipe={text}/pizza_img={img}")
    suspend fun addPizza(
        @Path("name") name: String,
        @Path("text") recipe: String,
        @Path("img") pizzaImg: ByteArray
    )

    @GET("/update/pizza/id={name}/new_name={n_name}/recipe={text}/pizza_img={img}")
    suspend fun updatePizza(
        @Path("name") name: String,
        @Path("n_name") newName: String,
        @Path("text") recipe: String,
        @Path("img") pizzaImg: ByteArray
    )

    @GET("/remove/pizza/id={name}")
    suspend fun removePizza(
        @Path("name") name: String
    )
}