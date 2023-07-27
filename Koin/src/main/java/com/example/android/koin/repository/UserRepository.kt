package com.example.android.koin.repository

import com.example.android.koin.model.UserModel
import java.util.*

class UserRepository: IUserRepository {

    private var list = mutableListOf<UserModel>()

    override fun fetchUser(model: UserModel): List<UserModel> {
        model.name = model.name.toUpperCase(Locale.US)
        list.add(model)
        return list
    }
}
