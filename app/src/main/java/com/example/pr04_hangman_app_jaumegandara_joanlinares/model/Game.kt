package com.example.pr04_hangman_app_jaumegandara_joanlinares.model

data class Game(
    val selectedWord: String,
    val difficulty: String,
    val guessedLetters: MutableList<Char> = mutableListOf(),
    val usedLetters: MutableList<Char> = mutableListOf(),
    val remainingAttempts: Int,
    val isGameWon: Boolean = false,
    val isGameOver: Boolean = false
)