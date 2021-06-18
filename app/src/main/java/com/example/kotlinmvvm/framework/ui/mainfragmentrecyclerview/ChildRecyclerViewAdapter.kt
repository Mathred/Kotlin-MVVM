package com.example.kotlinmvvm.framework.ui.mainfragmentrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.ChildRecyclerviewReleasedMovieItemBinding
import com.example.kotlinmvvm.model.entities.Movie


class ChildRecyclerViewAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: ChildRecyclerviewReleasedMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val movieNameTV = binding.mainFragmentChildRVCVMovieNameTV
        val movieYearReleasedTV = binding.mainFragmentChildRVCVYearReleasedTV
        val movieRatingTV = binding.mainFragmentChildRVCVMovieRatingTV
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChildRecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ChildRecyclerviewReleasedMovieItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildRecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.movieNameTV.text = movieList[position].name
        holder.movieYearReleasedTV.text = movieList[position].yearReleased.toString()
        holder.movieRatingTV.text = movieList[position].rating.toString()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}