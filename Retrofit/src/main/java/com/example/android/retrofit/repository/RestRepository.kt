package com.example.android.retrofit.repository

import com.example.android.retrofit.CustomRetrofitCallback
import com.example.android.retrofit.GetDataService
import com.example.android.retrofit.RetrofitClientInstance
import com.example.android.retrofit.model.RestModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RestRepository {

    fun callRest(callback: CustomRetrofitCallback<RestModel>) {
        val service = RetrofitClientInstance.getRetrofitInstance()?.create(GetDataService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response= service!!.getUser()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body().let {
                        callback.success(response.body()!!)
                    }
                } else {
                    callback.error()
                }
            }
        }
    }
}