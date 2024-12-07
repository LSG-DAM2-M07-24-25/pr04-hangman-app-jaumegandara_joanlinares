package com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Model.Words

class GameViewModel : ViewModel() {
    val selectedWord = Words().getRandomWords("Easy")  // Exemple de dificultat "Easy"
    val remainingAttempts = mutableStateOf(6)  // Comença amb 6 intents
    val guessedLetters = mutableStateOf(mutableListOf<Char>())  // Lletres encertades per l'usuari

    // Funció per manejar el clic a una lletra
    fun onLetterClicked(letter: Char) {
        if (letter in selectedWord) {
            guessedLetters.value.add(letter)  // Afegir la lletra encertada
        } else {
            remainingAttempts.value -= 1  // Restar intents
        }
    }
}
