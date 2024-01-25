package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.helper.widget.Carousel
import androidx.databinding.DataBindingUtil
import coil.load
import com.example.sampleapp.adpaters.CarouselAdapter
import com.example.sampleapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main2)
        Log.d("heyy","stage1")
        val carousel=findViewById<Carousel>(R.id.carousel)

        Log.d("heyy","stage2")
       val carouselAdapter=CarouselAdapter()
        Log.d("heyy","stage3")
        carousel.setAdapter(carouselAdapter)
        Log.d("CarouselDebug", "Carousel: $carousel")
        Log.d("AdapterType", "Adapter Type: ${carouselAdapter.javaClass.simpleName}")
    }
}