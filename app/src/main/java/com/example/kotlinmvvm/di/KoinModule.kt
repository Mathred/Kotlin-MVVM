package com.example.kotlinmvvm.di

import com.example.kotlinmvvm.framework.viewmodels.MainViewModel
import com.example.kotlinmvvm.model.repository.Repository
import com.example.kotlinmvvm.model.repository.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single<Repository> { RepositoryImpl() }

    //View models
    viewModel { MainViewModel(get()) }

}