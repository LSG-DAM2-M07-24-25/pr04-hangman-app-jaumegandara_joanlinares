package com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Model.Words


class GameViewModel(difficulty: String) : ViewModel() {
    val selectedWord = Words().getRandomWords(difficulty)
    val remainingAttempts = mutableIntStateOf(6)
    @SuppressLint("MutableCollectionMutableState")
    val guessedLetters = mutableStateOf(mutableListOf<Char>())

    fun onLetterClicked(letter: Char) {
        if (letter in selectedWord) {
            guessedLetters.value.add(letter)
        } else {
            remainingAttempts.value -= 1
        }
    }
}
