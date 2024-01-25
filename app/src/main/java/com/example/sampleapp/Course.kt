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
       val carouselFragment=CarouselFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.child_fragment_container,carouselFragment)
        transaction.commit()
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
        list.add(Video(R.drawable.video_player, "Marketing content 2", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 3", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 4", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 5", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 6", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 7", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 8", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 9", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 10", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 11", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 12", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 13", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 14", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 15", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 16", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 17", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 18", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 19", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Marketing content 20", "Learn design basics"))


    }

    private fun loadCodingContent() {
        list.add(Video(R.drawable.video_player, "Coding 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 2", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 3", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 4", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 5", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 6", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 7", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 8", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 9", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 10", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 11", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 12", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 13", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 14", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 15", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 16", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 17", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 18", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 19", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Coding 20", "Learn design basics"))


    }

    private fun loadDesignThinkingContent() {
        list.add(Video(R.drawable.video_player, "Design Basic 1", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 2", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 3", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 4", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 5", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 6", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 7", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 8", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 9", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 10", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 11", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 12", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 13", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 14", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 15", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 16", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 17", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 18", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 19", "Learn design basics"))
        list.add(Video(R.drawable.video_player, "Design Basic 20", "Learn design basics"))

    }

    private fun init1() {

       binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())

        videoAdapter = VideoAdapter(list)
       binding.recyclerview.adapter = videoAdapter


    }


}
