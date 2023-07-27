package com.example.android.retrofit

import com.example.android.retrofit.model.RestModel
import retrofit2.Response
import retrofit2.http.GET

interface GetDataService {

    @GET("/api/users/3")
    suspend fun getUser(): Response<RestModel>
}