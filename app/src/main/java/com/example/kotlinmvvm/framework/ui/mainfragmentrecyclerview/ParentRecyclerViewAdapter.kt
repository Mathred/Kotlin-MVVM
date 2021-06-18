package com.example.kotlinmvvm.framework.ui.mainfragmentrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.ParentRecyclerviewItemBinding
import com.example.kotlinmvvm.model.entities.Category
import com.example.kotlinmvvm.model.entities.Movie

class ParentRecyclerViewAdapter(private val categoryList: List<Category>, val context: Context) :
    RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(binding: ParentRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val categoryNameTV = binding.mainFragmentChildCategoryTextview
        val childRV = binding.mainFragmentChildRecyclerview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ParentRecyclerviewItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = with(holder) {
        categoryNameTV.text = categoryList[position].category

        childRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        childRV.setHasFixedSize(true)
        childRV.adapter = ChildRecyclerViewAdapter(categoryList[position].movieList)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}