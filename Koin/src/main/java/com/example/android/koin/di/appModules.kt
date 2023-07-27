package com.example.android.koin.di

import com.example.android.koin.repository.IUserRepository
import com.example.android.koin.repository.UserRepository
import com.example.android.koin.viewModel.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {

    viewModel {
        UserViewModel(get())
    }

    single {
        UserRepository() as IUserRepository
    }
}