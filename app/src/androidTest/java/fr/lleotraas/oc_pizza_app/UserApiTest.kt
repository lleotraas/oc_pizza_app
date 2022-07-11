package fr.lleotraas.oc_pizza_app

import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.lleotraas.oc_pizza_app.retrofit.RetrofitInstance
import fr.lleotraas.oc_pizza_app.utils.UtilsTest
import fr.lleotraas.oc_pizza_app.utils.UtilsTest.Companion.USER_ACCOUNT_NAME
import fr.lleotraas.oc_pizza_app.utils.UtilsTest.Companion.USER_ACCOUNT_NAME_UPDATED
import fr.lleotraas.oc_pizza_app.utils.UtilsTest.Companion.USER_TO_CREATE
import fr.lleotraas.oc_pizza_app.utils.UtilsTest.Companion.USER_TO_UPDATE
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserApiTest {

    @Test
    fun test_a_getAllUser() {
        runBlocking {
            val api = RetrofitInstance.userApi
            val response = api.getAllUsers()
            assertEquals(8, response.size)
        }
    }

    @Test
    fun test_b_addUserTest() {
        runBlocking {
            val api = RetrofitInstance.userApi
            val response = api.addUser(
                USER_TO_CREATE.accountName,
                USER_TO_CREATE.accountPassword,
                USER_TO_CREATE.firstname,
                USER_TO_CREATE.lastName,
                USER_TO_CREATE.phoneNumber,
                USER_TO_CREATE.address,
                USER_TO_CREATE.role
            )
            assertEquals(response!!.accountName, USER_TO_CREATE.accountName)
        }
    }

    @Test
    fun test_c_getUserTest() {
        runBlocking {
            val api = RetrofitInstance.userApi
            val response = api.getUser(USER_ACCOUNT_NAME)
            assertEquals(USER_TO_CREATE.firstname, response.firstname)
            assertEquals(USER_TO_CREATE.lastName, response.lastName)
            assertEquals(USER_TO_CREATE.phoneNumber, response.phoneNumber)
        }
    }

    @Test
    fun test_d_updateUserTest() {
        runBlocking {
            val api = RetrofitInstance.userApi
            val response = api.updateUser(
                USER_ACCOUNT_NAME,
                USER_TO_UPDATE.accountName,
                USER_TO_UPDATE.accountPassword,
                USER_TO_UPDATE.firstname,
                USER_TO_UPDATE.lastName,
                USER_TO_UPDATE.phoneNumber,
                USER_TO_UPDATE.address,
                USER_TO_UPDATE.role
            )
            assertEquals(true, response)
        }
    }

    @Test
    fun test_e_removeUserTest() {
        runBlocking {
            val api = RetrofitInstance.userApi
            val response = api.removeUser(USER_ACCOUNT_NAME_UPDATED)
            assertEquals(true, response)
        }
    }

    @Test
    fun test_f_accountNameExistTest() {
        runBlocking {
            val api = RetrofitInstance.userApi
            val response = api.accountNameExist(USER_ACCOUNT_NAME_UPDATED)
            assertEquals(false, response)
        }
    }
}