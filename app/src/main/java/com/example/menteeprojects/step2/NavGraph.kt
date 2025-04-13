package com.example.menteeprojects.step2


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.menteeprojects.ui.MainScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {

        composable("main") {
            MainScreen()
        }
        composable("animated") {
            ListAnimatedItemsScreen()
        }

        composable("books") {
            BookListScreen()
        }
        composable("scaffold") {
            ScaffoldExample()
        }
    }
}