package com.example.sampleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapp.adpaters.VideoAdapter
import com.example.sampleapp.databinding.FragmentCourseBinding
import com.example.sampleapp.dataclasses.Video


class Course : Fragment() {

private lateinit var binding: FragmentCourseBinding
private lateinit var list:ArrayList<Video>
private lateinit var videoAdapter:VideoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

      binding=DataBindingUtil.inflate(inflater,R.layout.fragment_course, container, false)
        val view =binding.root
        list= ArrayList()
        when (arguments?.getString("item1")) {
            "Design Thinking" -> loadDesignThinkingContent()
            "Coding" -> loadCodingContent()
            "Marketing" -> loadMarketingContent()
            // Add more cases as needed
            else -> loadDefaultContent()
        }
        init1()
        return view
    }

    private fun loadDefaultContent() {
        list.add(Video(R.drawable.video_player, "Design Basic", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Concepts & Models", "Brining it all together"))
        list.add(Video(R.drawable.video_player, "Planning for success", "Why we are doing this?"))
        list.add(Video(R.drawable.video_player, "Design Basic", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Concepts & Models", "Brining it all together"))
        list.add(Video(R.drawable.video_player, "Planning for success", "Why we are doing this?"))
    }

    private fun loadMarketingContent() {
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 1", "Learn design basics"))


    }

    private fun loadCodingContent() {
        list.add(Video(R.drawable.video_player, "Coding 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 2", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 3", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 4", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 5", "Learn design basics"))

    }

    private fun loadDesignThinkingContent() {
        list.add(Video(R.drawable.video_player, "Design Basic 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 2", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 3", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 4", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 5", "Learn design basics"))

    }

    private fun init1() {

       binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        videoAdapter = VideoAdapter(list)
       binding.recyclerview.adapter = videoAdapter


    }


}
