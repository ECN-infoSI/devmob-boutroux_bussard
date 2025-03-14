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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class EcritureScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleMailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BottomBar(
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
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBar(top: @Composable () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { Bar() } // This ensures the BottomBar stays at the bottom
    ) { paddingValues ->
        // Your screen content goes here
        Box(modifier = Modifier.padding(paddingValues)) {
            top()
        }
    }

}

//https://www.geeksforgeeks.org/bottom-navigation-bar-in-android-using-kotlin/
@Composable
fun Bar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth() // Make Row span full width
            .height(100.dp), // Set the height of the bottom bar
        horizontalArrangement = Arrangement.Center // Center the buttons
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .weight(1f) // Make buttons expand equally
                .fillMaxHeight(), // Ensure they fill the row's height
            shape = RectangleShape // Make them rectangular
        ) {
            Text(stringResource(id = R.string.retour))
        }
        Button(
            onClick = { },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RectangleShape
        ) {
            Text(stringResource(id = R.string.joindre))
        }
        Button(
            onClick = { },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            shape = RectangleShape
        ) {
            Text(stringResource(id = R.string.envoyer))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EcriturePreview() {
    SimpleMailTheme {
        BottomBar(
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
            }
        )
    }
}