package com.example.pr04_hangman_app_jaumegandara_joanlinares.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Model.Words

@Composable
fun GameScreen(navController: NavController) {
    val difficulty = navController.currentBackStackEntry?.arguments?.getString("difficulty") ?: "Easy"

    val words = Words()
    val selectedWord = remember { words.getRandomWords(difficulty) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dificultat: $difficulty",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Paraula: $selectedWord",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}
