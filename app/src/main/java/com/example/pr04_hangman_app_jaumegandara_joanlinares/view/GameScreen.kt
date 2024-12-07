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
import com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel.GameViewModel

@Composable
fun GameScreen(navController: NavController, gameViewModel: GameViewModel = viewModel()) {
    val difficulty = navController.currentBackStackEntry?.arguments?.getString("difficulty") ?: "Easy"
    val remainingAttempts by gameViewModel.remainingAttempts
    val guessedLetters by gameViewModel.guessedLetters
    val selectedWord = gameViewModel.selectedWord
    val wordDisplay = selectedWord.map { if (it in guessedLetters) it else '_' }.joinToString(" ")
    val alphabet = ('A'..'Z').toList()
    val letterGroups = alphabet.chunked(6)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = GallowImage(remainingAttempts)),
            contentDescription = "Hangman",
            modifier = Modifier
                .width(350.dp)
                .height(350.dp)
        )

        Text(
            text = wordDisplay,
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
                            .padding(4.dp).height(60.dp),
                        onClick = { gameViewModel.onLetterClicked(letter) },
                        enabled = !guessedLetters.contains(letter),
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        Text(
                            text = letter.toString(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }
        }

        Text(
            text = "Intents restants: $remainingAttempts",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 32.dp)
        )
    }
}

@Composable
fun GallowImage(remainingAttempts: Int): Int {
    return when (remainingAttempts) {
        0 -> R.drawable.gallows6
        1 -> R.drawable.gallows5
        2 -> R.drawable.gallows4
        3 -> R.drawable.gallows3
        4 -> R.drawable.gallows2
        5 -> R.drawable.gallows1
        else -> R.drawable.gallows0
    }
}
