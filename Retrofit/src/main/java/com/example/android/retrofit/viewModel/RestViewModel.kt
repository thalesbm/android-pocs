package com.example.android.retrofit.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.retrofit.CustomRetrofitCallback
import com.example.android.retrofit.model.RestModel
import com.example.android.retrofit.repository.RestRepository

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
        repository.callRest(object : CustomRetrofitCallback<RestModel> {
            override fun success(t: RestModel) {
                observable.value = t
            }

            override fun error() {
                observableString.value = "error"
            }
        })
    }
}
