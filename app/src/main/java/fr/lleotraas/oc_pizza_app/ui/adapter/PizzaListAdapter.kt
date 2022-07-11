package fr.lleotraas.oc_pizza_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.lleotraas.oc_pizza_app.databinding.RowPizzaListBinding
import fr.lleotraas.oc_pizza_app.model.Pizza
import fr.lleotraas.oc_pizza_app.utils.Utils

class PizzaListAdapter : ListAdapter<Pizza, PizzaListAdapter.PizzaListViewHolder> (Companion) {

    inner class PizzaListViewHolder(val binding: RowPizzaListBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Pizza>() {
        override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaListViewHolder {
        return PizzaListViewHolder(RowPizzaListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PizzaListViewHolder, position: Int) {
        val pizza = currentList[position]
        holder.binding.apply {
            rowPizzaListPizzaName.text = pizza.name
            Glide.with(holder.binding.root)
                .load(Utils.getPizzaImgFromPizzaName(pizza.name))
                .centerCrop()
                .into(rowPizzaListImg)
        }
    }
}