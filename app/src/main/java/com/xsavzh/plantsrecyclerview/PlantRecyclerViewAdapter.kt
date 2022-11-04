package com.xsavzh.plantsrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.xsavzh.plantsrecyclerview.databinding.PlantItemBinding

class PlantRecyclerViewAdapter: RecyclerView.Adapter<PlantRecyclerViewAdapter.PlantHolder>() {

    private val plantList = ArrayList<Plant>()

    class PlantHolder(item: View): ViewHolder(item) {

        private val binding = PlantItemBinding.bind(item)

        fun bind (plant: Plant) = with(binding) {
            plantImageView.setImageResource(plant.imageId)
            plantTextView.text = plant.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }
}