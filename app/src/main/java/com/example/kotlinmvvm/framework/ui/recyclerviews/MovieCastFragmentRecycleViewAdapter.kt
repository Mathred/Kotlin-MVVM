package com.example.kotlinmvvm.framework.ui.recyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.MovieCastFragmentRecyclerviewItemBinding
import com.example.kotlinmvvm.model.entities.Actor

class MovieCastFragmentRecycleViewAdapter(
    private val actorList: List<Actor>,
    val context: Context
) :
    RecyclerView.Adapter<MovieCastFragmentRecycleViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: MovieCastFragmentRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val photoIV = binding.movieCastFragmentRVItemPhoto
        val nameTV = binding.movieCastFragmentRVItemName
        val roleTV = binding.movieCastFragmentRVItemRole
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieCastFragmentRecyclerviewItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = with(holder) {
//     photoIV.setImageDrawable(actorList[position].photo)
        nameTV.text = actorList.getOrNull(position)?.firstName + " " + actorList.getOrNull(position)?.lastName
//     roleTV.text = actorList[position].role
    }

    override fun getItemCount() = actorList.size

}