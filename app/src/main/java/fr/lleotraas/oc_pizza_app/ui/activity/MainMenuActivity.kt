package fr.lleotraas.oc_pizza_app.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import fr.lleotraas.oc_pizza_app.R
import fr.lleotraas.oc_pizza_app.databinding.ActivityMainBinding
import fr.lleotraas.oc_pizza_app.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureToolbar()
        configureNavigationDrawer()
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.activityMainMenuToolbar.toolbarMainMenu)
    }

    private fun configureNavigationDrawer() {
        val toggleButton = ActionBarDrawerToggle(this, binding.activityMainMenuDrawerLayout, binding.activityMainMenuToolbar.toolbarMainMenu, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.activityMainMenuDrawerLayout.addDrawerListener(toggleButton)
        toggleButton.syncState()
//        val parentView = binding.activityMainMenuNavigationView.getHeaderView(0)
    }
}