package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.Drink
import retrofit2.http.GET
import retrofit2.http.Path

interface DrinkApi {

    @GET("/drinks")
    suspend fun getAllDrink(): List<Drink>

    @GET("/drink/id={name}")
    suspend fun getDrink(
        @Path("name") name: String
    ): Drink

    @GET("/add/drink/id={name}")
    suspend fun addDrink(
        @Path("name") name: String,
    )

    @GET("/update/drink/id={name}/new_name={n_name}")
    suspend fun updateDrink(
        @Path("name") name: String,
        @Path("n_name") newName: String
    )

    @GET("/remove/drink/id={name}")
    suspend fun removeDrink(
        @Path("name") name: String
    )
}