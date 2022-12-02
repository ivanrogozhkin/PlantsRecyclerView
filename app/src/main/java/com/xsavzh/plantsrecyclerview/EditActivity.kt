package com.xsavzh.plantsrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xsavzh.plantsrecyclerview.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    private var imageIndex: Int = 0
    private var imageId = R.drawable.geran
    private val imageList = listOf(
        R.drawable.geran,
        R.drawable.pion,
        R.drawable.podsolnuh,
        R.drawable.romashka,
        R.drawable.rose,
        R.drawable.tulpan
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtons()
    }

    private fun initButtons() = with(binding) {
        nextPicButton.setOnClickListener {
            imageIndex++
            if (imageIndex > imageList.size - 1) imageIndex = 0
            imageId = imageList[imageIndex]
            plantImageView.setImageResource(imageId)
        }

        prevPicButton.setOnClickListener {
            imageIndex--
            if (imageIndex < 0) imageIndex = imageList.size - 1
            imageId = imageList[imageIndex]
            plantImageView.setImageResource(imageId)
        }

        doneButton.setOnClickListener {
            val plant = Plant(imageId, titleEditText.text.toString(), descriptionEditText.text.toString())
            val editIntent = Intent().apply {
                putExtra("plant", plant)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}