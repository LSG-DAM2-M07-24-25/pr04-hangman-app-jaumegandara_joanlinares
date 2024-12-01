package com.example.pr04_hangman_app_jaumegandara_joanlinares.Model

data class Result(
    val isWin: Boolean,
    val wordToGuess: String,
    val attemptsUsed: Int,
    val totalScore: Int
)
