package fr.lleotraas.oc_pizza_app.utils


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import fr.lleotraas.oc_pizza_app.R
import kotlin.math.sign

class Utils {
    companion object {
        fun getPizzaImgFromPizzaName(pizzaName: String): Int {
            return when(pizzaName) {
                "bacon L" -> { R.drawable.pizza_bacon }
                "pizza jambon L" -> { R.drawable.pizza_jambon }
                "reine L" -> { R.drawable.pizza_reine }
                else -> { R.drawable.pizza_margarita }
            }

        }


    }
}