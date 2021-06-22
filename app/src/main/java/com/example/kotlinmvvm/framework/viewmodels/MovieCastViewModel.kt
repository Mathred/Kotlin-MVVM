package com.example.kotlinmvvm.framework.viewmodels

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.appstates.MainFragmentAppState
import com.example.kotlinmvvm.model.repository.Repository

class MovieCastViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {

    private val liveDataToObserve: MutableLiveData<MainFragmentAppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getData() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = MainFragmentAppState.Loading
        Thread {
            Thread.sleep(1000)
            liveDataToObserve.postValue(
                MainFragmentAppState.Success(repository.getActorListFromLocalStorage(null))
            )
        }.start()
    }

}