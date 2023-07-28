package com.example.android.okhttp3

interface CustomRequestCallback<T> {

    fun success(t: T)

    fun error()
}