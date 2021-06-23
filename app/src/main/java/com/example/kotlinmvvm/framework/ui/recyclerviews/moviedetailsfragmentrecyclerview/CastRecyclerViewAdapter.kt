package com.example.kotlinmvvm.framework.ui.recyclerviews.moviedetailsfragmentrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvm.databinding.MovieDetailsCastRecyclerViewItemBinding
import com.example.kotlinmvvm.model.entities.ActorList

class CastRecyclerViewAdapter(private var actorsList: ActorList?, val context: Context) :
    RecyclerView.Adapter<CastRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: MovieDetailsCastRecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val photoIV = binding.filmDetailsCastRVPhotoIV
        val nameTV = binding.filmDetailsCastRVNameTV
        val roleTV = binding.filmDetailsCastRVRoleTV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieDetailsCastRecyclerViewItemBinding.inflate(inflater)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = with(holder){
//        photoIV.setImageDrawable(actorsList[position].photo)
        nameTV.text = actorsList?.cast?.getOrNull(position)?.firstName + " " + actorsList?.cast?.getOrNull(position)?.lastName
//        roleTV.text = actorsList[position].role
    }

    override fun getItemCount() = actorsList?.cast?.size ?: 0

    fun setItems(actorsList: ActorList?) {
        this.actorsList = actorsList
        notifyDataSetChanged()
    }
}