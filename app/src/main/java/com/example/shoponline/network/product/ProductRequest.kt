package com.example.shoponline.network.product

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class ProductRequest(
    //This data class is used when the Product is created. It will convert the values
    // to this variables and send it to the database

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