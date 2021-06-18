package com.example.kotlinmvvm.framework.ui.main.recyclerviews.moviedetailsfragmentrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.FilmDetailsCastRecyclerViewItemBinding
import com.example.kotlinmvvm.model.entities.Actor

class CastRecyclerViewAdapter(private val actorsList: List<Actor>, val context: Context) :
    RecyclerView.Adapter<CastRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: FilmDetailsCastRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val photoIV = binding.filmDetailsCastRVPhotoIV
        val nameTV = binding.filmDetailsCastRVNameTV
        val roleTV = binding.filmDetailsCastRVRoleTV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FilmDetailsCastRecyclerViewItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = with(holder){
//        photoIV.setImageDrawable(actorsList[position].photo)
        nameTV.text = actorsList[position].firstName + " " + actorsList[position].lastName
//        roleTV.text = actorsList[position].role
    }

    override fun getItemCount() = actorsList.size
}