package com.example.shoponline

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shoponline.enums.Route
import com.example.shoponline.navigation.BottomNavigationBar
import com.example.shoponline.navigation.Navigation
import com.example.shoponline.ui.theme.ShopOnlineTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopOnlineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    
                    ShowBottomNav(navigationController = navigationController)

                }
            }
        }
    }
}


// Redirects to other pages for bottom navigation and throughout the application
@Composable
fun ShowBottomNav(navigationController: NavHostController){
    //Scaffold layout for designing layout design. Top bars, bottom bars
    Scaffold(bottomBar = {
        BottomNavigationBar(items = listOf(
            BottomBarScreen(
                route = Route.PRODUCT_LIST.name,
                title = stringResource(id = R.string.products_nav_tab_title),
                icon = Icons.Default.List
            ),
            BottomBarScreen(
                route = Route.FAVORITES.name,
                title = stringResource(id = R.string.favorites_nav_tab_title),
                icon = Icons.Default.Favorite
            ),
            BottomBarScreen(
                route = Route.PROFILE.name,
                title = stringResource(id = R.string.profile_nav_tab_title),
                icon = Icons.Default.AccountBox
            ),
            BottomBarScreen(
                route = Route.SETTINGS.name,
                title = stringResource(id = R.string.settings_nav_tab_title),
                icon = Icons.Default.Settings
            )
        ), navigationController = navigationController, onItemClick = {
            navigationController.navigate(it.route)
        })
    }) {
        Navigation(navigationController = navigationController)
    }
}
