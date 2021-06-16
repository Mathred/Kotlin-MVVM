package com.example.kotlinmvvm.ui.main

import android.util.Log
import androidx.lifecycle.*
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.repository.Repository
import com.example.kotlinmvvm.model.repository.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel() : ViewModel(), LifecycleObserver {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val repository: Repository = RepositoryImpl()

    fun getLiveData() = liveDataToObserve

    fun getData() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(
                AppState.Success(repository.getDataFromLocalStorage())
            )
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onViewStart() {
        Log.i("LifecycleEvent", "OnStart")
    }
}