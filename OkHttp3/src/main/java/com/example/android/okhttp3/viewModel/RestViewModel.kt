package com.example.android.okhttp3.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.okhttp3.CustomRequestCallback
import com.example.android.okhttp3.model.RestModel
import com.example.android.okhttp3.repository.RestRepository

class RestViewModel(private val repository: RestRepository) : ViewModel() {

    private val observable: MutableLiveData<RestModel> by lazy {
        MutableLiveData<RestModel>()
    }

    fun getCustomObservable(): MutableLiveData<RestModel> {
        return observable
    }

    private val observableString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getCustomStringObservable(): MutableLiveData<String> {
        return observableString
    }

    fun callRepository() {
        repository.callRest(object : CustomRequestCallback<RestModel> {
            override fun success(t: RestModel) {
                observable.value = t
            }

            override fun error() {
                observableString.value = "error"
            }
        })
    }
}
