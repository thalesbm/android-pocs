package com.example.android.okhttp3

import okhttp3.OkHttpClient
import okhttp3.Request

object ClientInstance {

    private val client = OkHttpClient()

    fun getInstance(): String {
        val url = "https://reqres.in/api/users/3"
        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""
    }
}
