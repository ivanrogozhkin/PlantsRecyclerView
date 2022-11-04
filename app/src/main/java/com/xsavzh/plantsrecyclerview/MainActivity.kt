package com.xsavzh.plantsrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xsavzh.plantsrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val imageIdList = listOf(
        R.drawable.geran,
        R.drawable.pion,
        R.drawable.podsolnuh,
        R.drawable.romashka,
        R.drawable.rose,
        R.drawable.tulpan)

    private var index = 0

    private lateinit var binding: ActivityMainBinding
    private val adapter = PlantRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter
        init()
    }

    private fun init() = with(binding){
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
        recyclerView.adapter = adapter
        addPlantBtn.setOnClickListener {
            if (index > 5) index = 0

            lateinit var title: String
            when (index) {
                0 -> title = "Geranium"
                1 -> title = "Peony"
                2 -> title = "Sunflower"
                3 -> title = "Chamomile"
                4 -> title = "Rose"
                5 -> title = "Tulip"
            }

            val plant = Plant(imageIdList[index], title)
            adapter.addPlant(plant)
            index++
        }
    }
}