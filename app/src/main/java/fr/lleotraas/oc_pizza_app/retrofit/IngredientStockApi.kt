package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.IngredientStock
import retrofit2.http.GET
import retrofit2.http.Path

interface IngredientStockApi {

    @GET("/ingredient_stock")
    suspend fun getAllIngredientStock(): List<IngredientStock>

    @GET("/ingredient_stock/id={name}")
    suspend fun getIngredientStock(
        @Path("name") name: String
    ): IngredientStock

    @GET("/add/ingredient_stock/id={name}")
    suspend fun addIngredientStock(
        @Path("name") name: String,
    )

    @GET("/update/ingredient_stock/id={name}/new_name={n_name}")
    suspend fun updateIngredientStock(
        @Path("name") name: String,
        @Path("n_name") newName: String
    )

    @GET("/remove/ingredient_stock/id={name}")
    suspend fun removeIngredientStock(
        @Path("name") name: String
    )
}