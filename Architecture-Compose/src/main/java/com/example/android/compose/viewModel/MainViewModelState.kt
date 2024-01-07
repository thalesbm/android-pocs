package com.example.android.compose.viewModel

sealed class MainViewModelState {

    data class LoadScreen(val title: String) : MainViewModelState()

    data class UpdateScreen(val title: String) : MainViewModelState()
}
