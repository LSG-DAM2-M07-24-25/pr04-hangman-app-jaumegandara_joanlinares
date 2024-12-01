package com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class MenuViewModel : ViewModel() {

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    init {
        startLoading()
    }

    private fun startLoading() {
        viewModelScope.launch {
            delay(4000)
            _isLoading.value = false
        }
    }
}