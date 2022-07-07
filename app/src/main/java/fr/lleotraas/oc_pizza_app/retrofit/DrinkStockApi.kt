package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.DrinkStock
import retrofit2.http.GET
import retrofit2.http.Path

interface DrinkStockApi {

    @GET("/drinks_stock")
    suspend fun getAllDrinkStock(): List<DrinkStock>

    @GET("/drink_stock/id={name}")
    suspend fun getDrinkStock(
        @Path("name") name: String
    ): DrinkStock

    @GET("/add/drink_stock/id={name}")
    suspend fun addDrinkStock(
        @Path("name") name: String,
    )

    @GET("/update/drink_stock/id={name}/new_name={n_name}")
    suspend fun updateDrinkStock(
        @Path("name") name: String,
        @Path("n_name") newName: String
    )

    @GET("/remove/drink_stock/id={name}")
    suspend fun removeDrinkStock(
        @Path("name") name: String
    )
}