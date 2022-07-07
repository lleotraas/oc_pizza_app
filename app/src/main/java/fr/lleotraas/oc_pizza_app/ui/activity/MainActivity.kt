package fr.lleotraas.oc_pizza_app.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.lleotraas.oc_pizza_app.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}