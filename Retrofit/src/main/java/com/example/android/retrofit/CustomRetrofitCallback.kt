package com.example.android.retrofit

interface CustomRetrofitCallback<T> {

    fun success(t: T)

    fun error()
}