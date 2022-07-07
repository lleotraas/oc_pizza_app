package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("/products")
    suspend fun getAllProduct(): List<Product>

    @GET("/product/id={name}")
    suspend fun getProduct(
        @Path("name") name: String
    ): Product

    @GET("/add/product/id={name}/unit_price_df={udf}/description={d}/vat_rate={vat}")
    suspend fun addProduct(
        @Path("name") name: String,
        @Path("udf") unitPriceDf: Float,
        @Path("d") description: String,
        @Path("vat") vatRate: Float
    )

    @GET("/update/product/id={name}/new_name={n_name}/unit_price_df={udf}/description={d}/vat_rate={vat}")
    suspend fun updateProduct(
        @Path("name") name: String,
        @Path("n_name") newName: String,
        @Path("udf") unitPriceDf: Float,
        @Path("d") description: String,
        @Path("vat") vatRate: Float
    )

    @GET("/remove/product/id={name}")
    suspend fun removeProduct(
        @Path("name") name: String
    )
}