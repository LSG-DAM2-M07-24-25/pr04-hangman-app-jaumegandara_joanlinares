package com.example.pr04_hangman_app_jaumegandara_joanlinares.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Routes

@Composable
fun EntryPoint(navigationController: NavController) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.Screen1.route
    ) {
        composable(Routes.Screen1.route) { MenuScreen(navigationController) }

        composable(Routes.Screen2.route) { GameScreen(navigationController) }

        composable(Routes.Screen3.route) { ResultScreen(navigationController) }
    }
}