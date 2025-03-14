package com.centrale.simplemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.centrale.simplemail.ui.theme.SimpleMailTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

class EcritureScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleMailTheme {

                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BottomBar.Show(
                        top=
                            {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text("Hello, this is the top content!", fontSize = 24.sp)
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Button(onClick = { /* Do something */ }) {
                                        Text("Click Me")
                                    }
                                }
                            },
                        buttons = listOf(TypeButton.Retour, TypeButton.Joindre, TypeButton.Envoyer), // Specify the buttons to display
                        navController= navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EcriturePreview() {
    val navController= rememberNavController()
    SimpleMailTheme {
        BottomBar.Show(
            {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Hello, this is the top content!", fontSize = 24.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { /* Do something */ }) {
                        Text("Click Me")
                    }
                }
            },
            buttons = listOf(TypeButton.Retour, TypeButton.Joindre, TypeButton.Envoyer), // Specify the buttons to display
            navController= navController
        )
    }
}