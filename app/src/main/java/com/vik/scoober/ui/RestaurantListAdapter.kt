package com.vik.scoober.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vik.scoober.databinding.RowBinding
import com.vik.scoober.domain.model.Restraurant
import com.vik.scoober.ui.RestaurantListAdapter.RestaurantViewHolder

class RestaurantListAdapter() : Adapter<RestaurantViewHolder>() {
    private val restaurantList: MutableList<Restraurant> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowBinding.inflate(inflater,parent,false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bindData(restaurantList[position])
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    fun updateData(list: List<Restraurant>) {
        restaurantList.clear()
        restaurantList.addAll(list)
        notifyDataSetChanged()
    }

    class RestaurantViewHolder(private val rowBinding: RowBinding) : ViewHolder(rowBinding.root) {
        fun bindData(restaurant: Restraurant) {
            rowBinding.tvName.text = restaurant.name
            rowBinding.tvStatus.text = restaurant.status.text
        }
    }

}