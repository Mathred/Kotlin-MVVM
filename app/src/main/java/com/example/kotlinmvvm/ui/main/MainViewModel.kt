package com.example.kotlinmvvm.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.AppState
import com.example.kotlinmvvm.model.repository.Repository
import com.example.kotlinmvvm.model.repository.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel() : ViewModel() {

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
}