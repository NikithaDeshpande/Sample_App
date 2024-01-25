package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import androidx.databinding.DataBindingUtil
import coil.load
import com.example.sampleapp.databinding.ActivityMain4Binding


class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private lateinit var list: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main4)
        list = listOf(
            "https://i.postimg.cc/nr0fMmS3/Logo.png",
            "https://www.thewowstyle.com/wp-content/uploads/2024/01/1-12-680x450.jpg",
            "https://www.thewowstyle.com/wp-content/uploads/2024/01/1-680x450.png",
            "https://www.thewowstyle.com/wp-content/uploads/2024/01/1-10-680x450.jpg",
            "https://www.thewowstyle.com/wp-content/uploads/2024/01/Aesthetics-of-Illumination-680x450.jpg",
            "https://www.thewowstyle.com/wp-content/uploads/2024/01/pexels-johann-1254140-680x450.jpg",
            "https://www.thewowstyle.com/wp-content/uploads/2024/01/1-2-680x450.jpg",
            "https://www.thewowstyle.com/wp-content/uploads/2023/12/1-21-680x450.png"
        )
        binding.carousel4.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return list.size
            }

            override fun populate(view: View?, index: Int) {
                val v = view as ViewGroup
                val imageView = v.getChildAt(1) as ImageView
                imageView.load(list[index]) {
                    error(R.drawable.image1)
                    placeholder(R.drawable.image2)
                }
            }

            override fun onNewItem(index: Int) {
                //do nothing
            }

        })
    }


}