package com.example.kotlinmvvm.framework.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.repository.Repository

class MovieCastViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getData() {
        TODO("Not yet implemented")
    }

}