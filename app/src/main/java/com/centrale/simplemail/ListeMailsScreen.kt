package com.centrale.simplemail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ListeMailsScreen(navController: NavController) {
    // Your UI content for the LectureScreen
    BottomBar.Show(
        top= {
            Text(text = "Welcome to the Liste Mails Screen!")
        },
        buttons = listOf(TypeButton.EnvoyerMail, TypeButton.Parametres), // Specify the buttons to display
        navController= navController
    )
}