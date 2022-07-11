package fr.lleotraas.oc_pizza_app.retrofit

import fr.lleotraas.oc_pizza_app.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users")
    suspend fun getAllUsers(): List<User>

    @GET("/user/account_name={an}")
    suspend fun getUser(
        @Path("an") accountName: String
    ): User

    @GET("/account_name_exist/account_name={an}")
    suspend fun accountNameExist(
        @Path("an") accountName: String
    ): Boolean

    @GET("/add/user/account_name={an}/account_password={ap}/firstname={fname}/lastname={lname}/phone={pnumber}/address={location}/role={employment}")
    suspend fun addUser(
        @Path("an") accountName: String,
        @Path("ap") accountPassword: String,
        @Path("fname") firstName: String,
        @Path("lname") lastName: String,
        @Path("pnumber") phoneNumber: String,
        @Path("location") address: String,
        @Path("employment") role: String
    ): User?

    @GET("/update/account_name={an}/new_account_name={nan}/account_password={ap}/firstname={fname}/lastname={lname}/phone={pnumber}/address={location}/role={employment}")
    suspend fun updateUser(
        @Path("an") accountName: String,
        @Path("nan") newAccountName: String,
        @Path("ap") accountPassword: String,
        @Path("fname") firstName: String,
        @Path("lname") lastName: String,
        @Path("pnumber") phoneNumber: String,
        @Path("location") address: String,
        @Path("employment") role: String
    ): Boolean

    @GET("/remove/account_name={an}")
    suspend fun removeUser(
        @Path("an") accountName: String
    ): Boolean
}