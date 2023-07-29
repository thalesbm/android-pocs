package com.example.android.okhttp3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.okhttp3.CustomRequestCallback
import com.example.android.okhttp3.repository.RestRepository

class RestViewModel(private val repository: RestRepository) : ViewModel() {

    private val observable: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getCustomObservable(): MutableLiveData<String> {
        return observable
    }

    private val observableString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getCustomStringObservable(): MutableLiveData<String> {
        return observableString
    }

    fun callRepository() {
        repository.callRest(object : CustomRequestCallback<String> {
            override fun success(t: String) {
                observable.value = t
            }

            override fun error() {
                observableString.value = "error"
            }
        })
    }
}
