package fr.lleotraas.oc_pizza_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.lleotraas.oc_pizza_app.databinding.FragmentPizzaListBinding
import fr.lleotraas.oc_pizza_app.model.Pizza
import fr.lleotraas.oc_pizza_app.retrofit.RetrofitInstance
import fr.lleotraas.oc_pizza_app.ui.adapter.PizzaListAdapter
import fr.lleotraas.oc_pizza_app.ui.viewmodel.PizzaViewModel

class PizzaListFragment : Fragment() {

    private lateinit var binding: FragmentPizzaListBinding
    private lateinit var adapter: PizzaListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPizzaListBinding.inflate(inflater, container, false)
        adapter = PizzaListAdapter()
        setupRecyclerView()
        updateUI()
        return binding.root
    }

    private fun updateUI() {
        val viewModel = PizzaViewModel(RetrofitInstance.pizzaApi)
        viewModel.getAllPizza().observe(viewLifecycleOwner) { listOfPizza ->
            loadPizzaFromRecyclerView(listOfPizza)
        }
    }

    private fun setupRecyclerView() = binding.fragmentPizzaListRv.apply {
        layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
//        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun loadPizzaFromRecyclerView(listOfPizza: List<Pizza>) {
        adapter.submitList(listOfPizza)
        binding.fragmentPizzaListRv.adapter = adapter
    }

}