package com.example.android.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RestModel(
    @SerializedName("data") @Expose
    val userModel: UserModelResponse
) {
    class UserModelResponse(
        @SerializedName("id") @Expose val id: Int,
        @SerializedName("email") @Expose val email: String,
        @SerializedName("first_name") @Expose val firstName: String,
        @SerializedName("last_name") @Expose val lastName: String
    )
}
