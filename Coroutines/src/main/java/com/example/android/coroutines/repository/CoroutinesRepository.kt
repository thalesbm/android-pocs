package com.example.android.coroutines.repository

import kotlinx.coroutines.delay

class CoroutinesRepository {

    suspend fun getNumber(number: Int): Int {
        delay(1500)
        return number
    }
}