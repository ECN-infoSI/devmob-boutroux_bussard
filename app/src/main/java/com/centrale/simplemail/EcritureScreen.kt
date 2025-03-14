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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

class EcritureScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleMailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ecriture(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Ecriture(name: String, modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { BottomBar() } // This ensures the BottomBar stays at the bottom
    ) { paddingValues ->
        // Your screen content goes here
        Box(modifier = Modifier.padding(paddingValues)) {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
    }

}

//https://www.geeksforgeeks.org/bottom-navigation-bar-in-android-using-kotlin/
@Composable
fun BottomBar(modifier: Modifier = Modifier) {
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
        Ecriture("Android")
    }
}