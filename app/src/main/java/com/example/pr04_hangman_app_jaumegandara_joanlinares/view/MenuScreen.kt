package com.example.pr04_hangman_app_jaumegandara_joanlinares.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.navigation.NavController
import com.example.pr04_hangman_app_jaumegandara_joanlinares.Model.Menu

@Composable
fun MenuScreen(navController: NavController) {
    val context = LocalContext.current
    var difficulty by remember { mutableStateOf(Menu().difficulty) }
    var isDropdownExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column{
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
                    text = { Text("Easy") },
                    onClick = { difficulty = "Easy"; isDropdownExpanded = false }
                )
                DropdownMenuItem(
                    text = { Text("Medium") },
                    onClick = { difficulty = "Medium"; isDropdownExpanded = false }
                )
                DropdownMenuItem(
                    text = { Text("Hard") },
                    onClick = { difficulty = "Hard"; isDropdownExpanded = false }
                )
            }
        }

        Button(
            modifier = Modifier.padding(16.dp).width(350.dp).height(75.dp),
            onClick = { navController.navigate("screen2") }
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
