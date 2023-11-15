package com.example.shoponline.models

import java.time.LocalDateTime

data class Product (
    val id: Int,
    val name: String,
    val price: Double,
    val contactPhone: String,
    val Status: String,
    val isFavorite: Boolean,
    val description: String
    )