package com.example.shoponline.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shoponline.BottomBarScreen
import com.example.shoponline.detailedView.DetailedProductDescr
import com.example.shoponline.enums.Route
import com.example.shoponline.favorites.Favorites
import com.example.shoponline.list.ProdsList
import com.example.shoponline.profile.Profile
import com.example.shoponline.settings.Settings



// Style for the bottom navigation
@Composable
fun BottomNavigationBar(
    items: List<BottomBarScreen>,
    navigationController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomBarScreen) -> Unit
){
    val stackEntry = navigationController.currentBackStackEntryAsState()

    BottomNavigation(modifier = modifier, backgroundColor = Color.Cyan, elevation = 15.dp) {
        for (item in items) {
            var selectedItem = false;

            if(item.route == stackEntry.value?.destination?.route) {
                selectedItem = true
            }
            BottomNavigationItem(
                selected = selectedItem,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.title)
                        Text(text = item.title, textAlign = TextAlign.Center)
                    }
                })
        }
    }
}

// Checks the value with the clicked item and redirects to the other page
@Composable
fun Navigation(navigationController: NavHostController){
    NavHost(navController = navigationController, startDestination = Route.PRODUCT_LIST.name){
        composable(route = Route.PRODUCT_LIST.name){
            ProdsList( onProductClick = {productId -> navigationController.navigate("detailedView/$productId")})
        }
        composable(route = Route.PROFILE.name){
            Profile()
        }
        composable(route = Route.FAVORITES.name){
            Favorites()
        }
        composable(route = Route.SETTINGS.name){
            Settings()
        }
        
        composable(
            "detailedView/{productId}"
        ){
            navBackStackEntry ->navBackStackEntry.arguments?.getString("productId")?.let { DetailedProductDescr(
            productId = it
        ) }
        }
    }
}