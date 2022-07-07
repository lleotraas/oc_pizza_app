package fr.lleotraas.oc_pizza_app.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.lleotraas.oc_pizza_app.model.User
import fr.lleotraas.oc_pizza_app.retrofit.UserApi
import kotlinx.coroutines.launch

class MainViewModel(
    private val userApi: UserApi
) : ViewModel() {

    private var user = MutableLiveData<User>()

    fun addUser(
        accountName: String,
        accountPassword: String,
        firstname: String,
        lastname: String,
        phoneNumber: String,
        address: String
    ) {
        viewModelScope.launch {
            var role = "customer"
            userApi.addUser(
                accountName,
                accountPassword,
                firstname,
                lastname,
                phoneNumber,
                address,
                role
            )
        }
    }
}