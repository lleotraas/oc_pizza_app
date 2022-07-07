package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users")
    suspend fun getAllUsers(): List<User>

    @GET("//user/identification={id}")
    suspend fun getUser(
        @Path("id") id: Int
    ): User

    @GET("/add/user/account_name={an}/account_password={ap}/firstname={fname}/lastname={lname}/phone={pnumber}/address={location}/role={employment}")
    suspend fun addUser(
        @Path("an") accountName: String,
        @Path("ap") accountPassword: String,
        @Path("fname") firstName: String,
        @Path("lname") lastName: String,
        @Path("pnumber") phoneNumber: String,
        @Path("location") address: String,
        @Path("employment") role: String
    )

    @GET("/update/identification={id}/account_name={an}/account_password={ap}/firstname={fname}/lastname={lname}/phone={pnumber}/address={location}/role={employment}")
    suspend fun updateUser(
        @Path("id") id: Int,
        @Path("an") accountName: String,
        @Path("ap") accountPassword: String,
        @Path("fname") firstName: String,
        @Path("lname") lastName: String,
        @Path("pnumber") phoneNumber: String,
        @Path("location") address: String,
        @Path("employment") role: String
    )

    @GET("/remove/identification={id}")
    suspend fun removeUser(
        @Path("id") id: Int
    )
}