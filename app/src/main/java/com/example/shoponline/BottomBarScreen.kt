package com.example.shoponline

import androidx.compose.ui.graphics.vector.ImageVector


// Data class that holds the variables for checking specific pages by route (For bottom navigation)
data class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
)