package com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pr04_hangman_app_jaumegandara_joanlinares.model.Words


class GameViewModel(difficulty: String) : ViewModel() {
    val selectedWord = Words().getRandomWords(difficulty).uppercase()
    val remainingAttempts = mutableIntStateOf(6)
    @SuppressLint("MutableCollectionMutableState")
    val guessedLetters = mutableStateOf(setOf<Char>())
    @SuppressLint("MutableCollectionMutableState")
    val usedLetters = mutableStateOf(setOf<Char>())

    fun onLetterClicked(letter: Char) {
        if (letter in usedLetters.value) return // Evita clics repetidos

        usedLetters.value += letter // Marca la letra como usada

        if (letter in selectedWord) {
            guessedLetters.value += letter // Añade la letra acertada
        } else {
            remainingAttempts.value -= 1 // Reduce intentos si la letra no está
        }
    }

    fun isLetterUsed(letter: Char): Boolean {
        return usedLetters.value.contains(letter) // Comprueba si ya se usó la letra
    }
}
