package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.PizzaOrder
import retrofit2.http.GET
import retrofit2.http.Path

interface PizzaOrderApi {

    @GET("/pizza_order")
    suspend fun getAllPizzaOrder(): List<PizzaOrder>

    @GET("/pizza_order/id={identification}")
    suspend fun getPizzaOrder(
        @Path("identification") id: Int
    ): PizzaOrder

    @GET("/add/pizza_order/id={identification}/user_id={uid}/restaurant_name={r_name}/creation_date={date}/delivery_hour={hour}/delivery_state={state}/is_paid={paid}/is_delivery={delivery}/amount={total}")
    suspend fun addPizzaOrder(
        @Path("identification") id: Int,
        @Path("uid") userId: Int,
        @Path("r_name") restaurantName: String,
        @Path("date") creationDate: String,
        @Path("hour") deliveryHour: String,
        @Path("state") deliveryState: String,
        @Path("paid") isPaid: Boolean,
        @Path("delivery") isDelivery: Boolean,
        @Path("total") amount: Float
    )

    @GET("/update/pizza_order/id={identification}/user_id={uid}/restaurant_name={r_name}/creation_date={date}/delivery_hour={hour}/delivery_state={state}/is_paid={paid}/is_delivery={delivery}/amount={total}")
    suspend fun updatePizzaOrder(
        @Path("identification") id: Int,
        @Path("uid") userId: Int,
        @Path("r_name") restaurantName: String,
        @Path("date") creationDate: String,
        @Path("hour") deliveryHour: String,
        @Path("state") deliveryState: String,
        @Path("paid") isPaid: Boolean,
        @Path("delivery") isDelivery: Boolean,
        @Path("total") amount: Float
    )

    @GET("/remove/pizza_order/id={identification}")
    suspend fun removePizzaOrder(
        @Path("identification") id: Int
    )
}