package fr.lleotraas.oc_pizza_app

import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.lleotraas.oc_pizza_app.retrofit.RetrofitInstance
import fr.lleotraas.oc_pizza_app.utils.PizzaUtilsTest.Companion.PIZZA_NAME
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PizzaApiTest {

    @Test
    fun test_getPizza() {
        runBlocking {
            val api = RetrofitInstance.pizzaApi
            val response = api.getPizza(PIZZA_NAME)
            assertEquals(response.name, PIZZA_NAME)
        }

    }
}