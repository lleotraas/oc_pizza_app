package fr.lleotraas.oc_pizza_app.ui.activity

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import fr.lleotraas.oc_pizza_app.R
import fr.lleotraas.oc_pizza_app.databinding.ActivityMainMenuBinding
import fr.lleotraas.oc_pizza_app.ui.PageAdapter

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureToolbar()
        configureNavigationDrawer()
        configureViewPager()
        configureListener()
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

    private fun configureViewPager() {
        binding.activityMainMenuViewPager.isUserInputEnabled = false
        val fragmentManager = supportFragmentManager
        val adapter = PageAdapter(fragmentManager, lifecycle)
        binding.activityMainMenuViewPager.adapter = adapter
        this.setTabLayoutName()
        this.setTabLayoutIcon()
        this.setTabLayoutListener()
    }

    private fun setTabLayoutName() {
        binding.apply {
            activityMainMenuTab.addTab(activityMainMenuTab.newTab().setText(R.string.activity_main_menu_pizza_tab))
            activityMainMenuTab.addTab(activityMainMenuTab.newTab().setText(R.string.activity_main_menu_drink_tab))
            activityMainMenuTab.addTab(activityMainMenuTab.newTab().setText(R.string.activity_main_menu_dessert_tab))
        }
    }

    private fun setTabLayoutIcon() {
        binding.apply {
            activityMainMenuTab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_local_pizza)
            activityMainMenuTab.getTabAt(0)!!.icon!!.setColorFilter(ContextCompat.getColor(applicationContext, R.color.red), PorterDuff.Mode.SRC_IN)
            activityMainMenuTab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_local_drink)
            activityMainMenuTab.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_cookie)
        }
    }

    private fun setTabLayoutListener() {
        binding.apply {
            activityMainMenuTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    activityMainMenuViewPager.currentItem = tab!!.position
                    tab.icon!!.setColorFilter(ContextCompat.getColor(applicationContext, R.color.red), PorterDuff.Mode.SRC_IN)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    tab!!.icon!!.setColorFilter(ContextCompat.getColor(applicationContext, R.color.black), PorterDuff.Mode.SRC_IN)
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {  }
            })

            activityMainMenuViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    activityMainMenuTab.selectTab(activityMainMenuTab.getTabAt(position))
                }
            })
        }
    }

    private fun configureListener() {
        binding.activityMainMenuNavigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.activity_main_menu_drawer_menu_quit -> { goToMainActivity() }
                else -> { false }

            }
        }

    }

    private fun goToMainActivity(): Boolean {
        startActivity(
            Intent(this, MainActivity::class.java))
        return true
    }
}