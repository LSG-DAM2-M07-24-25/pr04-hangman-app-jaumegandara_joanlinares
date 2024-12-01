package com.example.pr04_hangman_app_jaumegandara_joanlinares.view

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pr04_hangman_app_jaumegandara_joanlinares.R
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Routes
import com.example.pr04_hangman_app_jaumegandara_joanlinares.viewModel.MenuViewModel


@Composable
fun MenuScreen(navController: NavController, viewModel: MenuViewModel = viewModel()) {
    val isLoading by viewModel.isLoading
    val context = LocalContext.current

    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.hangman),
                contentDescription = "Hangman",
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)
            )
            CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var difficulty by remember { mutableStateOf("Medium") }
            var isDropdownExpanded by remember { mutableStateOf(false) }

            Image(
                painter = painterResource(id = R.drawable.hangman),
                contentDescription = "Hangman",
                modifier = Modifier
                    .width(400.dp)
                    .height(400.dp)
            )

            Button(
                modifier = Modifier.padding(16.dp).width(350.dp).height(75.dp),
                onClick = { isDropdownExpanded = true }
            ) {
                Text(
                    "Difficulty: $difficulty",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            DropdownMenu(
                expanded = isDropdownExpanded,
                onDismissRequest = { isDropdownExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                DropdownMenuItem(
                    text = { Text("Easy", fontSize = 24.sp) },
                    onClick = { difficulty = "Easy"; isDropdownExpanded = false }
                )
                DropdownMenuItem(
                    text = { Text("Medium", fontSize = 24.sp) },
                    onClick = { difficulty = "Medium"; isDropdownExpanded = false }
                )
                DropdownMenuItem(
                    text = { Text("Hard", fontSize = 24.sp) },
                    onClick = { difficulty = "Hard"; isDropdownExpanded = false }
                )
            }

            Button(
                modifier = Modifier.padding(16.dp).width(350.dp).height(75.dp),
                onClick = { navController.navigate(Routes.Screen2.createRoute(difficulty)) }
            ) {
                Text(
                    "Start Game",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                modifier = Modifier.padding(16.dp).width(350.dp).height(75.dp),
                onClick = { (context as? Activity)?.finishAffinity() }
            ) {
                Text(
                    "Quit",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

