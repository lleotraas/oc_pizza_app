package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApi {

    @GET("/restaurants")
    suspend fun getAllRestaurants(): List<Restaurant>

    @GET("/restaurant/id={name}")
    suspend fun getRestaurant(
        @Path("name") name: String
    ): Restaurant

    @GET("/add/restaurant/id={name}/location={address}")
    suspend fun addRestaurant(
        @Path("name") name: String,
        @Path("address") address: String
    )

    @GET("/update/restaurant/id={name}/new_name={n_name}/address={location}")
    suspend fun updateRestaurant(
        @Path("name") name: String,
        @Path("n_name") newName: String,
        @Path("location") address: String,
    )

    @GET("/remove/restaurant/id={name}")
    suspend fun removeRestaurant(
        @Path("name") name: String
    )

}