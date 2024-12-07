package com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Model.Words

class GameViewModel : ViewModel() {
    val selectedWord = Words().getRandomWords("Easy")
    val remainingAttempts = mutableStateOf(6)
    val guessedLetters = mutableStateOf(mutableListOf<Char>())

    fun onLetterClicked(letter: Char) {
        if (letter in selectedWord) {
            guessedLetters.value.add(letter)
        } else {
            remainingAttempts.value -= 1
        }
    }
}
