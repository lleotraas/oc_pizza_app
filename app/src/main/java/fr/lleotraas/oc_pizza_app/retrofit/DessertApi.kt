package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.Dessert
import retrofit2.http.GET
import retrofit2.http.Path

interface DessertApi {

    @GET("/desserts")
    suspend fun getAllDessert(): List<Dessert>

    @GET("/dessert/id={name}")
    suspend fun getDessert(
        @Path("name") name: String
    ): Dessert

    @GET("/add/dessert/id={name}")
    suspend fun addDessert(
        @Path("name") name: String,
    )

    @GET("/update/dessert/id={name}/new_name={n_name}")
    suspend fun updateDessert(
        @Path("name") name: String,
        @Path("n_name") newName: String
    )

    @GET("/remove/dessert/id={name}")
    suspend fun removeDessert(
        @Path("name") name: String
    )
}