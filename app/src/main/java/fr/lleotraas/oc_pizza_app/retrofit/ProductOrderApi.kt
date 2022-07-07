package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.ProductOrder
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductOrderApi {

    @GET("/product_order")
    suspend fun getAllProductOrder(): List<ProductOrder>

    @GET("/product_order/id={name}")
    suspend fun getProductOrder(
        @Path("name") name: String
    ): ProductOrder

    @GET("/add/product_order/id={name}/order_id={oid}/vat_rate={vat}/quantity={q}/unit_price_df={upd}")
    suspend fun addProductOrder(
        @Path("name") name: String,
        @Path("oid") orderId: Int,
        @Path("vat") varRate: Float,
        @Path("q") quantity: Int,
        @Path("upd") unitPriceDf: Float
    )

    @GET("/update/product_order/id={name}/new_name={n_name}/order_id={oid}/vat_rate={vat}/quantity={q}/unit_price_df={upd}")
    suspend fun updateProductOrder(
        @Path("name") name: String,
        @Path("n_name") newName: String,
        @Path("oid") orderId: Int,
        @Path("vat") varRate: Float,
        @Path("q") quantity: Int,
        @Path("upd") unitPriceDf: Float
    )

    @GET("/remove/product_order/id={name}")
    suspend fun removeProductOrder(
        @Path("name") name: String
    )
}