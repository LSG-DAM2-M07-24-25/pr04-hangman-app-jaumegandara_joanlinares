package com.example.pr04_hangman_app_jaumegandara_joanlinares.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pr04_hangman_app_jaumegandara_joanlinares.R
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Routes
import com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel.GameViewModel

@Composable
fun GameScreen(navController: NavController, gameViewModel: GameViewModel = viewModel()) {
    val game by gameViewModel.gameState

    // Observa el evento de navegación
    val navigateToResult by gameViewModel.navigateToResult

    // Navega a la pantalla de resultado si el evento se activa
    navigateToResult?.let { (isGameWon, attempts) ->
        navController.navigate(Routes.Screen3.createRoute(isGameWon, attempts))
        gameViewModel.resetNavigation()
    }

    val alphabet = ('A'..'Z').toList()
    val letterGroups = alphabet.chunked(6)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = gallowImage(game.remainingAttempts)),
            contentDescription = "Hangman",
            modifier = Modifier
                .width(350.dp)
                .height(350.dp)
        )

        Text(
            text = buildWordDisplay(game.selectedWord, game.guessedLetters),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(32.dp)
        )

        letterGroups.forEach { group ->
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                items(group) { letter ->
                    Button(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(60.dp),
                        onClick = { gameViewModel.onLetterClicked(letter) },
                        enabled = !game.guessedLetters.contains(letter),
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (game.guessedLetters.contains(letter)) Color.Gray else Color.Transparent,
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Text(
                            text = letter.toString(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.wrapContentSize(Alignment.Center),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            }
        }

        Text(
            text = "Intentos fallidos: ${game.remainingAttempts}",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 32.dp)
        )
    }
}

@Composable
fun gallowImage(remainingAttempts: Int): Int {
    return when (remainingAttempts) {
        0 -> R.drawable.gallows0
        1 -> R.drawable.gallows1
        2 -> R.drawable.gallows2
        3 -> R.drawable.gallows3
        4 -> R.drawable.gallows4
        5 -> R.drawable.gallows5
        6 -> R.drawable.gallows6
        else -> R.drawable.gallows0
    }
}

fun buildWordDisplay(selectedWord: String, guessedLetters: MutableList<Char>): String {
    return selectedWord.map { char ->
        if (guessedLetters.contains(char)) char else '_'
    }.joinToString(" ")
}
