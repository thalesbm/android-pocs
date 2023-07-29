package com.example.android.okhttp3.repository

import com.example.android.okhttp3.ClientInstance
import com.example.android.okhttp3.CustomRequestCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RestRepository {

    fun callRest(callback: CustomRequestCallback<String>) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = ClientInstance.getInstance()
            withContext(Dispatchers.Main) {
                if (response.isNotEmpty()) {
                    callback.success(response)
                } else {
                    callback.error()
                }
            }
        }
    }
}