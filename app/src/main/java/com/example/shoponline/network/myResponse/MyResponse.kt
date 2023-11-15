package com.example.shoponline.network.myResponse

import com.google.gson.annotations.SerializedName

open class MyResponse () {
    // Whenever the GET, POST, DELETE, EDIT are called, there will be a response.
    // This class stores the status response and by this we can make checks whether,
    // GET POSTS are worked properly

    @SerializedName("code")
    val code: String = ""
    @SerializedName("status")
    val status: String = ""
    @SerializedName("message")
    val message: String = ""
}