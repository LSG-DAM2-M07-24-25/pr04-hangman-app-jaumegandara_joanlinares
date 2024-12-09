package com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pr04_hangman_app_jaumegandara_joanlinares.model.Words
import com.example.pr04_hangman_app_jaumegandara_joanlinares.model.Game


class GameViewModel(difficulty: String) : ViewModel() {
    private val maxAttempts = 6
    val difficulty = difficulty
    val gameState = mutableStateOf(
        Game(
            selectedWord = Words().getRandomWords(difficulty).uppercase(),
            remainingAttempts = 0,
            difficulty = difficulty
        )
    )

    var navigateToResult = mutableStateOf<Triple<Boolean, Int, String>?>(null)
        private set

    fun onLetterClicked(letter: Char) {
        val currentGame = gameState.value
        if (currentGame.isGameOver || currentGame.guessedLetters.contains(letter)) return

        val updatedGuessedLetters = currentGame.guessedLetters.toMutableList()
        val updatedAttempts = currentGame.remainingAttempts + if (letter in currentGame.selectedWord) 0 else 1

        updatedGuessedLetters.add(letter)

        val isGameWon = currentGame.selectedWord.all { it in updatedGuessedLetters }
        val isGameOver = isGameWon || updatedAttempts >= maxAttempts

        gameState.value = currentGame.copy(
            guessedLetters = updatedGuessedLetters,
            remainingAttempts = updatedAttempts,
            isGameWon = isGameWon,
            isGameOver = isGameOver
        )

        // Emit a navigation event when the game ends
        if (isGameOver) {
            val attemptsUsed = updatedAttempts
            navigateToResult.value = Triple(isGameWon, attemptsUsed, difficulty)
        }
    }

    fun resetNavigation() {
        navigateToResult.value = null
    }
}
