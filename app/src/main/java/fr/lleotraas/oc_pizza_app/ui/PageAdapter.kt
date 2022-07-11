package fr.lleotraas.oc_pizza_app.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import fr.lleotraas.oc_pizza_app.ui.fragment.DessertListFragment
import fr.lleotraas.oc_pizza_app.ui.fragment.DrinkListFragment
import fr.lleotraas.oc_pizza_app.ui.fragment.PizzaListFragment

class PageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(
    fragmentManager,
    lifecycle
) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            1 -> {
                DrinkListFragment()
            }

            2 -> {
                DessertListFragment()
            }

            else -> {
                PizzaListFragment()
            }
        }
    }
}