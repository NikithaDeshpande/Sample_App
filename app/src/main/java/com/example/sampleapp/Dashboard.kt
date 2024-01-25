package com.example.sampleapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.sampleapp.adpaters.ItemAdapter
import com.example.sampleapp.databinding.FragmentDashboardBinding
import com.example.sampleapp.viewModel.ItemViewModel


class Dashboard : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var list: ArrayList<ItemViewModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        val view = binding.root
        binding.etSearchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle search query submission here
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
        list = ArrayList()
        init()
        return view
    }


    fun filterList(newText: String?) {
        val filteredList: ArrayList<ItemViewModel> = ArrayList()
        list.forEach { s ->
            if (s.item1.lowercase().contains(newText?.lowercase() ?: " ")) {
                filteredList.add(s)
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(context, "not found ", Toast.LENGTH_LONG).show()
        } else {
            itemAdapter.setFilteredList(filteredList)
        }
    }

    private fun init() {

        val itemViewModel = ItemViewModel().apply {
            image = R.drawable.img
            item1 = "Design Thinking"
            item2 = "19 courses"
        }
        val itemViewModel1 = ItemViewModel().apply {
            image = R.drawable.img1
            item1 = "Coding"
            item2 = "19 courses"
        }
        val itemViewModel2 = ItemViewModel().apply {
            image = R.drawable.img2
            item1 = "Marketing"
            item2 = "21 courses"
        }
        val itemViewModel3 = ItemViewModel().apply {
            image = R.drawable.img3
            item1 = "Security Expert"
            item2 = "19 courses"
        }
        val itemViewModel4 = ItemViewModel().apply {
            image = R.drawable.img4
            item1 = "Big Data"
            item2 = "15 courses"
        }
        list.add(itemViewModel)
        list.add(itemViewModel1)
        list.add(itemViewModel2)
        list.add(itemViewModel3)
        list.add(itemViewModel4)


        binding.recyclerview.setHasFixedSize(true)
        with(binding) {
            recyclerview.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            itemAdapter = ItemAdapter(list)
            recyclerview.adapter = itemAdapter
            itemAdapter.setOnClickListener(object :
                ItemAdapter.OnClickListener {
                override fun onClick(position: Int) {

                    val clickedItem = list[position]
                    val bundle = Bundle()
                    bundle.putString("item1", clickedItem.item1) // Put the data into the Bundle

                    val courseFragment = Course()
                    courseFragment.arguments =
                        bundle // Set the Bundle as arguments for the fragment

                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.navHostFragmentView,
                            courseFragment
                        ) // Replace fragment_container with your actual container ID
                        .addToBackStack(null) // Optionally, add to back stack
                        .commit()
//                        val intent = Intent(this@DashboardActivity, CourseActivity::class.java)
//                        // Passing the data to the
//                        // EmployeeDetails Activity
//                        startActivity(intent)
//                    val clickedItem = list[position] // Get the clicked item from the list
//                    val intent = Intent(@)
//                    intent.putExtra("item1", clickedItem.item1) // Pass item1 data to CourseActivity
//                    startActivity(intent)
                }
            })
        }

        binding.recyclerview.addItemDecoration(CustomItemDecoration(50))


    }

}