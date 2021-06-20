package com.example.kotlinmvvm.framework.viewmodels

import androidx.lifecycle.*
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.repository.Repository
import java.lang.Thread.sleep

class MainFragmentViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getData() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(
                AppState.Success(repository.getMovieListFromLocalStorage(null))
            )
        }.start()
    }
}