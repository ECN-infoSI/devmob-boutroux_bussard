package com.centrale.simplemail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.centrale.simplemail.screens.MailViewModel

/**
 * Displays  the settings, probably only the most important ones to not lose the user.
 * For now it is empty.
 */
@Composable
fun ParametresScreen(
    navController: NavController,
    viewModel: MailViewModel,
    modifier: Modifier) {
    BottomBar.Show(
        top= {
            Text(text = "Welcome to the Parametres Screen!")
        },
        buttons = listOf(TypeButton.Retour), // Specify the buttons to display
        navController= navController,
        viewModel = viewModel,
        modifier = Modifier,
    )
}