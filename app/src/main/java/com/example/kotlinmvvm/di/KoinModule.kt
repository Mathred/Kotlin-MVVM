package com.example.kotlinmvvm.di

import com.example.kotlinmvvm.framework.viewmodels.MainFragmentViewModel
import com.example.kotlinmvvm.framework.viewmodels.MovieCastViewModel
import com.example.kotlinmvvm.framework.viewmodels.MovieDetailsViewModel
import com.example.kotlinmvvm.model.repository.Repository
import com.example.kotlinmvvm.model.repository.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single<Repository> { RepositoryImpl() }

    //View models
    viewModel { MainFragmentViewModel(get()) }
    viewModel { MovieCastViewModel(get()) }
    viewModel { MovieDetailsViewModel(get()) }


}