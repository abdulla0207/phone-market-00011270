package com.example.shoponline.network.product

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class ProductResponse (
    // Data class that is used when any product comes from the api. The values in api will  be stored
    // to these variables by SerializedName annotation

    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("phone")
    val contactPhone: String,
    @SerializedName("type") // Storing status of the product into type
    val Status: String,
    @SerializedName("is_it_true")
    val isFavorite: Boolean,
    @SerializedName("description")
    val description: String
        )