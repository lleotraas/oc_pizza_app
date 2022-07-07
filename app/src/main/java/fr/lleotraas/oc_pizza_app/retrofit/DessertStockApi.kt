package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.DessertStock
import fr.lleotraas.oc_pizza_app.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Path

interface DessertStockApi {

    @GET("/desserts_stock")
    suspend fun getAllDessertStock(): List<DessertStock>

    @GET("/dessert_stock/id={name}")
    suspend fun getDessertStock(
        @Path("name") name: String
    ): DessertStock

    @GET("/add/dessert_stock/id={name}")
    suspend fun addDessertStock(
        @Path("name") name: String,
    )

    @GET("/update/dessert_stock/id={name}/new_name={n_name}")
    suspend fun updateDessertStock(
        @Path("name") name: String,
        @Path("n_name") newName: String
    )

    @GET("/remove/dessert_stock/id={name}")
    suspend fun removeDessertStock(
        @Path("name") name: String
    )
}