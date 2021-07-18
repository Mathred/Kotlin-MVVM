package com.example.kotlinmvvm.framework.ui.recyclerviews.mainfragmentrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.MainFragmentParentRecyclerviewItemBinding
import com.example.kotlinmvvm.framework.ui.recyclerviews.decorations.HorizontalListDividerItemDecorator
import com.example.kotlinmvvm.model.entities.Movie
import com.example.kotlinmvvm.model.entities.MovieCategory

class ParentRecyclerViewAdapter(
    private var categoryList: List<MovieCategory>?,
    val context: Context,
    private var clickListener: ItemClickListener<Movie>?
) :
    RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(
        binding: MainFragmentParentRecyclerviewItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        lateinit var adapter: ChildRecyclerViewAdapter
        val categoryNameTV = binding.mainFragmentChildCategoryTextview
        val childRV = binding.mainFragmentChildRecyclerview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainFragmentParentRecyclerviewItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = with(holder) {
        childRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        childRV.setHasFixedSize(true)
        childRV.addItemDecoration(HorizontalListDividerItemDecorator(8))
        adapter = ChildRecyclerViewAdapter(categoryList?.getOrNull(position)?.movieList, clickListener)
        childRV.adapter = adapter
        categoryNameTV.text = categoryList?.getOrNull(position)?.categoryTitle
    }

    override fun getItemCount(): Int {
        return categoryList?.size ?: 0
    }

    fun setItems(categoryList: List<MovieCategory>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

    fun setListener(itemClickListener: ItemClickListener<Movie>) {
        this.clickListener = itemClickListener
    }

}
