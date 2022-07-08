package fr.lleotraas.oc_pizza_app.ui.viewmodel

import androidx.lifecycle.LiveData
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
    private var isAccountNameExist = MutableLiveData<Boolean>()

    fun addUser(
        accountName: String,
        accountPassword: String,
        firstname: String,
        lastname: String,
        phoneNumber: String,
        address: String
    ): MutableLiveData<User> {
        viewModelScope.launch {
            val role = "customer"
            user.postValue(userApi.addUser(
                accountName,
                accountPassword,
                firstname,
                lastname,
                phoneNumber,
                address,
                role
            ))
        }
        return user
    }

    fun accountNameExist(accountName: String): MutableLiveData<Boolean> {
        viewModelScope.launch {
            isAccountNameExist.postValue(userApi.accountNameExist(accountName))
        }
        return isAccountNameExist
    }

    fun getUser(accountName: String): LiveData<User> {
        viewModelScope.launch {
            user.postValue(userApi.getUser(accountName))
        }
        return user
    }
}