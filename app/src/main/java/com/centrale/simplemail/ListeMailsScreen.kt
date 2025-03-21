package com.centrale.simplemail

import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.centrale.simplemail.BottomBar.HandleButtonClick
import com.centrale.simplemail.data.DataSource
import com.centrale.simplemail.screens.MailViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

@Composable
fun ListeMailsScreen(
    navController: NavController,
    viewModel: MailViewModel,
    modifier: Modifier) {
    // Your UI content for the LectureScreen
    BottomBar.Show(
        top= {
            Column {
                Text(text = "Welcome to the Liste Mails Screen!")
                Button(
                    onClick = {
                        navController.navigate(DataSource.Routes.lecture)
                    }, // Call navigation function
                    modifier = modifier,
                    shape = RectangleShape,
                ){
                    Text(
                        "test mail",
                        textAlign = TextAlign.Center
                    )
                }
            }
        },
        buttons = listOf(TypeButton.EnvoyerMail, TypeButton.Parametres), // Specify the buttons to display
        navController= navController,
        viewModel = viewModel,
        modifier = Modifier,
    )
}