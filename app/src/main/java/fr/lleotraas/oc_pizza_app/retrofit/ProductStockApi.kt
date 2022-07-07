package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.ProductStock
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductStockApi {

    @GET("/product_stock")
    suspend fun getAllProductStock(): List<ProductStock>

    @GET("/product_stock/id={name}")
    suspend fun getProductStock(
        @Path("name") name: String
    ): ProductStock

    @GET("/add/product_stock/id={name}/stock_name={sn}")
    suspend fun addProductStock(
        @Path("name") name: String,
        @Path("sn") stockName: String
    )

    @GET("/update/product_stock/id={name}/new_name={n_name}/stock_name={sn}")
    suspend fun updateProductStock(
        @Path("name") name: String,
        @Path("n_name") newName: String,
        @Path("sn") stockName: String
    )

    @GET("/remove/product_stock/id={name}")
    suspend fun removeProductStock(
        @Path("name") name: String
    )
}