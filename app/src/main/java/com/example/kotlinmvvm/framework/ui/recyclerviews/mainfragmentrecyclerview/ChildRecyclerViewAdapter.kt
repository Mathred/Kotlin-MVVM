package com.example.kotlinmvvm.framework.ui.recyclerviews.mainfragmentrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.MainFragmentChildRecyclerviewReleasedMovieItemBinding
import com.example.kotlinmvvm.model.entities.Movie


class ChildRecyclerViewAdapter(
    private val movieList: List<Movie>?,
    private val clickListener: ItemClickListener<Movie>?
) :
    RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(binding: MainFragmentChildRecyclerviewReleasedMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val movieNameTV = binding.mainFragmentChildRVCVMovieNameTV
        val movieYearReleasedTV = binding.mainFragmentChildRVCVYearReleasedTV
        val movieRatingTV = binding.mainFragmentChildRVCVMovieRatingTV
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainFragmentChildRecyclerviewReleasedMovieItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (movieList != null) {
            val movie = movieList.getOrNull(position)
            if (movie != null) {
                holder.movieNameTV.text = movie.title
                holder.movieYearReleasedTV.text = movie.yearReleased.toString()
                holder.movieRatingTV.text = movie.rating.toString()
                holder.itemView.setOnClickListener { clickListener?.onClickListener(movie) }
            }
        }
        return
    }

    override fun getItemCount(): Int {
        if (movieList != null) {
            return movieList.size
        }
        return 0
    }
}