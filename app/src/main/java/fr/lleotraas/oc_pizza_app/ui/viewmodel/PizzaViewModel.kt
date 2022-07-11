package fr.lleotraas.oc_pizza_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.lleotraas.oc_pizza_app.model.Pizza
import fr.lleotraas.oc_pizza_app.retrofit.PizzaApi
import kotlinx.coroutines.launch

class PizzaViewModel(
    private val pizzaApi: PizzaApi
) : ViewModel() {

    private val listOfPizza = MutableLiveData<List<Pizza>>()
    private val pizza = MutableLiveData<Pizza>()

    fun getPizza(name: String): LiveData<Pizza> {
        viewModelScope.launch {
            pizza.postValue(pizzaApi.getPizza(name))
        }
        return pizza
    }

    fun getAllPizza(): LiveData<List<Pizza>> {
        viewModelScope.launch {
            listOfPizza.postValue(pizzaApi.getAllPizza())
        }
        return listOfPizza
    }

}