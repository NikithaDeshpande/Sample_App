package com.example.sampleapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
@BindingAdapter("ImageUrl")
fun ImageView.LoadImageUrl(url:String?){
    this.load(url)
}