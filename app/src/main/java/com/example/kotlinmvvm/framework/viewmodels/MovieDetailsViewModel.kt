package com.example.kotlinmvvm.framework.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.repository.Repository

class MovieDetailsViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getData(): Any {
        TODO("Not yet implemented")
    }

    fun getLiveData() = liveDataToObserve
}