package com.example.sampleapp

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.helper.widget.Carousel
import androidx.databinding.DataBindingUtil
import coil.load
import com.example.sampleapp.databinding.FragmentCarouselBinding


@Suppress("DEPRECATION")
class CarouselFragment : Fragment() {
    private lateinit var binding: FragmentCarouselBinding
    private lateinit var list: List<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_carousel_, container, false)
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
        binding.carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return list.size
            }

            override fun populate(view: View?, index: Int) {
                val view1 = view as ViewGroup
                val imageView = view1.getChildAt(1) as ImageView
                val progressBar = view1.getChildAt(0) as ProgressBar
                imageView.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
                Handler().postDelayed({
                    imageView.load(list[index]) {
                        imageView.visibility = View.VISIBLE
                        placeholder(R.drawable.image1)
                        error(R.drawable.image2)
                    }

                    progressBar.visibility = View.GONE
                }, 3000)

            }

            override fun onNewItem(index: Int) {
                //do nothing
            }

        })
        return binding.root
    }


}