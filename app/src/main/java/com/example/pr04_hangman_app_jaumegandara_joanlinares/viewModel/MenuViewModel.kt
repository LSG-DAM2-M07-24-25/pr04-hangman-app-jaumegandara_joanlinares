package com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class MenuViewModel : ViewModel() {

    companion object {
        var hasLoadedInitially = false
    }

    private val _isLoading = mutableStateOf(!hasLoadedInitially)
    val isLoading: State<Boolean> = _isLoading

    init {
        if (!hasLoadedInitially) {
            startLoading()
        }
    }

    private fun startLoading() {
        viewModelScope.launch {
            delay(2000)
            _isLoading.value = false
            hasLoadedInitially = true
        }
    }
}