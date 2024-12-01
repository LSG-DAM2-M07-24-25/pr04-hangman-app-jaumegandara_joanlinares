package com.example.pr04_hangman_app_jaumegandara_joanlinares.Model

data class Menu(
    val difficulty: String = "easy",
    val disableVowels: Boolean = false,
    val maxAttempts: Int = 5
)
