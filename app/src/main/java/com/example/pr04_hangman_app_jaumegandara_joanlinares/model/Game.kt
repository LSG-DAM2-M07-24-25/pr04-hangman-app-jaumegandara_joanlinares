package com.example.pr04_hangman_app_jaumegandara_joanlinares.model

data class Game(
    val wordToGuess: String,
    val guessedLetters: MutableList<Char> = mutableListOf(),
    val remainingAttempts: Int,
    val isGameWon: Boolean = false,
    val isGameOver: Boolean = false
)