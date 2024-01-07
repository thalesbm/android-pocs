package com.example.android.compose.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val mutableLiveData = MutableLiveData<MainViewModelState>()
    val viewLiveData: LiveData<MainViewModelState> = mutableLiveData

    fun getTitle() {
        val title = "TITULO DA PAGINA"
        mutableLiveData.value = MainViewModelState.LoadScreen(title)
    }

    fun updateTitle() {
        val title = "TITULO DA PAGINA"
        mutableLiveData.value = MainViewModelState.UpdateScreen(title)
    }
}