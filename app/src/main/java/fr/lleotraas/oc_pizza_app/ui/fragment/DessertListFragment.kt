package fr.lleotraas.oc_pizza_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.lleotraas.oc_pizza_app.databinding.FragmentDessertListBinding

class DessertListFragment : Fragment() {

    private lateinit var binding: FragmentDessertListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDessertListBinding.inflate(inflater, container, false)
        return binding.root
    }

}