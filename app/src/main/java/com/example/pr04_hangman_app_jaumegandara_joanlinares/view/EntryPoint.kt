package com.example.pr04_hangman_app_jaumegandara_joanlinares.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Routes
import com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel.GameViewModel

@Composable
fun EntryPoint(navigationController: NavController) {
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.Screen1.route
    ) {
        composable(Routes.Screen1.route) { MenuScreen(navigationController) }

        composable(Routes.Screen2.route) { backStackEntry ->
            val difficulty = backStackEntry.arguments?.getString("difficulty") ?: "Medium"
            val gameViewModel = remember { GameViewModel(difficulty) }
            GameScreen(navigationController, gameViewModel)
        }

        composable(Routes.Screen3.route) { backStackEntry ->
            val isGameWon = backStackEntry.arguments?.getString("isGameWon")?.toBoolean() ?: false
            val attempts = backStackEntry.arguments?.getString("attempts")?.toInt() ?: 0
            val difficulty = backStackEntry.arguments?.getString("difficulty") ?: "Medium"
            ResultScreen(navigationController, isGameWon, attempts, difficulty)
        }
    }
}