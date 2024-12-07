package com.example.pr04_hangman_app_jaumegandara_joanlinares


sealed class Routes(val route: String) {
    object Screen1 : Routes("screen1")

    object Screen2 : Routes("screen2/{difficulty}") {
        fun createRoute(difficulty: String) = "screen2/$difficulty"
    }

    object Screen3 : Routes("screen3")
}