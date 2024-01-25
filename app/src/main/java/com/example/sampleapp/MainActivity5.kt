package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sampleapp.databinding.ActivityMain5Binding
import com.example.sampleapp.viewModel.Image

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main5)
        val image = Image("https://i.postimg.cc/nr0fMmS3/Logo.png")
        binding.imageUrl = image
    }
}