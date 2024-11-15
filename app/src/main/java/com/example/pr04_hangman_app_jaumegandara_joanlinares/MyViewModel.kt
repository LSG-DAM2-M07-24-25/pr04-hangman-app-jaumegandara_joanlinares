package com.example.pr04_hangman_app_jaumegandara_joanlinares

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var myVar: Boolean by mutableStateOf(false)
        private set

    fun modifyMyVar(value: Boolean) {
        myVar = value
    }
}