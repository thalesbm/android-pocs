package com.example.android.koin.repository

import com.example.android.koin.model.UserModel

interface IUserRepository {

    fun fetchUser(model: UserModel): List<UserModel>

}