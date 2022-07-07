package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.Stock
import retrofit2.http.GET
import retrofit2.http.Path

interface StockApi {

    @GET("/stocks")
    suspend fun getAllStock(): List<Stock>

    @GET("/stock/id={name}")
    suspend fun getStock(
        @Path("name") name: String
    ): Stock

    @GET("/add/stock/id={name}/remaining_quantity={rq}")
    suspend fun addStock(
        @Path("name") name: String,
        @Path("rq") remainingQuantity: Int
    )

    @GET("/update/stock/id={name}/new_name={n_name}/remaining_quantity={rq}")
    suspend fun updateStock(
        @Path("name") name: String,
        @Path("n_name") newName: String,
        @Path("rq") remainingQuantity: Int
    )

    @GET("/remove/stock/id={name}")
    suspend fun removeStock(
        @Path("name") name: String
    )
}