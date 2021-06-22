package com.example.kotlinmvvm.framework.viewmodels

import androidx.lifecycle.*
import com.example.kotlinmvvm.model.appstates.MainFragmentAppState
import com.example.kotlinmvvm.model.repository.Repository
import java.lang.Thread.sleep

class MainFragmentViewModel(private val repository: Repository) : ViewModel(), LifecycleObserver {

    private val liveDataToObserve: MutableLiveData<MainFragmentAppState> = MutableLiveData()

    fun getLiveData() = liveDataToObserve

    fun getData() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = MainFragmentAppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(
                MainFragmentAppState.Success(repository.getDefaultCategoriesList())
            )
        }.start()
    }
}