package com.centrale.simplemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.centrale.simplemail.ui.theme.SimpleMailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleMailTheme {
                Test()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleMailTheme {
        Greeting("Android")
    }
}

@Composable
fun Test() {
    val navController = rememberNavController()

    BottomBar.Show(
        top = {
            NavHost(
                navController,
                startDestination = "home_screen",
                Modifier.fillMaxSize()
            ) {
                composable("home_screen") { Text("Home Screen") }
                composable("previous_screen") { Text("Previous Screen") }
                composable("join_screen") { Text("Join Screen") }
                composable("send_screen") { Text("Send Screen") }
                composable("mail_list_screen") { Text("Mail List Screen") }
                composable("reply_screen") { Text("Reply Screen") }
                composable("delete_screen") { Text("Delete Screen") }
                composable("send_mail_screen") { Text("Send Mail Screen") }
                composable("settings_screen") { Text("Settings Screen") }
            }
        },
        buttons = listOf(TypeButton.Retour, TypeButton.Joindre, TypeButton.Envoyer),
        navController= navController,
        modifier = Modifier.fillMaxSize()
    )
}