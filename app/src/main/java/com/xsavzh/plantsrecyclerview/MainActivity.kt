package com.xsavzh.plantsrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.xsavzh.plantsrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val adapter = PlantRecyclerViewAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter
        init()

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
    }

    private fun init() = with(binding){
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        recyclerView.adapter = adapter
        addPlantBtn.setOnClickListener {
            editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
        }
    }
}