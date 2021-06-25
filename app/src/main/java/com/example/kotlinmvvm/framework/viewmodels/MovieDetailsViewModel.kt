package com.example.kotlinmvvm.framework.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.appstates.MovieDetailsAppState
import com.example.kotlinmvvm.model.repository.Repository

class MovieDetailsViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {

    private val liveDataToObserve: MutableLiveData<MovieDetailsAppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getData() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = MovieDetailsAppState.Loading
        Thread {
            Thread.sleep(1000)
            liveDataToObserve.postValue(
                MovieDetailsAppState.Success(repository.getMovieFromLocalStorage(null))
            )
        }.start()
    }
}