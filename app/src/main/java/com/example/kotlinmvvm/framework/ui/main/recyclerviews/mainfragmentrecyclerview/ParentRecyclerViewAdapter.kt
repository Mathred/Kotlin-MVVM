package com.example.kotlinmvvm.framework.ui.main.recyclerviews.mainfragmentrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.MainFragmentParentRecyclerviewItemBinding
import com.example.kotlinmvvm.framework.ui.main.recyclerviews.decorations.HorizontalListDividerItemDecorator
import com.example.kotlinmvvm.model.entities.Category

class ParentRecyclerViewAdapter(private val categoryList: List<Category>, val context: Context) :
    RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: MainFragmentParentRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val categoryNameTV = binding.mainFragmentChildCategoryTextview
        val childRV = binding.mainFragmentChildRecyclerview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainFragmentParentRecyclerviewItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = with(holder) {
        categoryNameTV.text = categoryList[position].category

        childRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        childRV.setHasFixedSize(true)
        childRV.addItemDecoration(HorizontalListDividerItemDecorator(8))
        childRV.adapter = ChildRecyclerViewAdapter(categoryList[position].movieList)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}