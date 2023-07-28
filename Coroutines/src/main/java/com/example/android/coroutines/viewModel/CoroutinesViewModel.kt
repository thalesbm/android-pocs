package com.example.android.coroutines.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.android.coroutines.repository.CoroutinesRepository

class CoroutinesViewModel(private val repository: CoroutinesRepository) {

    private val observable: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getCustomObservable() : MutableLiveData<Int> {
        return observable
    }

    suspend fun count() {
        for (x in 0..5) {
            val number = repository.getNumber(x)
            observable.postValue(number)
        }
    }
}