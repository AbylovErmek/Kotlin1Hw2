package com.geektech.kotlin1hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.kotlin1hw2.databinding.ActivityMainBinding
import com.geektech.kotlin1hw2.extension.loadImage
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listOfUrl = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupList()
        setupListeners()
    }

    private fun setupList() {
        listOfUrl.addAll(resources.getStringArray(R.array.image_urls))
    }

    private fun setupListeners() {
        binding.btnSumbit.setOnClickListener {
            if (!binding.etUrl.text.isNullOrEmpty()) {
                listOfUrl.add(binding.etUrl.text.toString())
                binding.etUrl.setText("")
            }
        }

        binding.btnRandom.setOnClickListener {
            binding.ivImage.loadImage(listOfUrl[random()])
        }
    }

    private fun random(): Int {
        return Random().nextInt(listOfUrl.size)
    }
}
