package com.example.android.okhttp3.repository

import com.example.android.okhttp3.ClientInstance
import com.example.android.okhttp3.CustomRequestCallback
import com.example.android.okhttp3.model.RestModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RestRepository {

    fun callRest(callback: CustomRequestCallback<RestModel>) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = ClientInstance.getInstance()
            withContext(Dispatchers.Main) {
                if (response.isNotEmpty()) {
                    callback.success(Gson().fromJson(response, RestModel::class.java))
                } else {
                    callback.error()
                }
            }
        }
    }
}