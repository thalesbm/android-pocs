package com.example.android.okhttp3

import okhttp3.OkHttpClient
import okhttp3.Request

object ClientInstance {

    private val client = OkHttpClient()
    private val BASE_URL = "https://reqres.in/api/users/3"

    fun getInstance(): String {
        val request = Request.Builder()
            .url(BASE_URL)
            .get()
            .build()

        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""

    }
}
