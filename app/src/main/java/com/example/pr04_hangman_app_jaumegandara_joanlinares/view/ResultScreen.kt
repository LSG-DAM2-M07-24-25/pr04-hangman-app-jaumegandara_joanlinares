package com.example.pr04_hangman_app_jaumegandara_joanlinares.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Routes

@Composable
fun ResultScreen(navController: NavController, isGameWon: Boolean, attempts: Int) {
    val resultText = if (isGameWon) "¡Ganaste!" else "¡Perdiste!"
    val resultColor = if (isGameWon) Color.Green else Color.Red

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = resultText,
            color = resultColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Intentos Fallidos: $attempts",
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { navController.navigate(Routes.Screen1.route) }) {
            Text(text = "Volver al menú")
        }
    }
}