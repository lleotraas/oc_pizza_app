package fr.lleotraas.oc_pizza_app.utils

import fr.lleotraas.oc_pizza_app.model.User

class UtilsTest {

    companion object {
        const val USER_FIRSTNAME = "jean-jacques"
        const val USER_LASTNAME = "cousto"
        const val USER_PHONE_NUMBER = "0605040302"
        const val USER_ACCOUNT_NAME = "user_test"
        const val USER_ACCOUNT_NAME_UPDATED = "new_user_test"
        const val USER_ACCOUNT_PASSWORD_UPDATED = "new_password"

        val USER_TO_CREATE = User(
            "user_test",
            "password",
            "user",
            "test",
            "0123456789",
            "rue des test",
            "testing"

        )

        val USER_TO_UPDATE = User(
            "new_user_test",
            "new_password",
            "user",
            "test",
            "0123456789",
            "rue des test",
            "testing"
        )
    }
}