package com.centrale.simplemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.centrale.simplemail.ui.theme.SimpleMailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavHost() // Launch the NavHost composable
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController() // Initialize the NavController

    // Define your NavHost
    NavHost(navController = navController, startDestination = "lecture_screen") {
        composable("lecture_screen") {
            LectureScreen(navController) // Navigate to LectureScreen
        }
        composable("ecriture_screen") {
            EcritureScreen(navController) // Navigate to EcritureScreen
        }
        composable("liste_mails_screen") {
            ListeMailsScreen(navController) // Navigate to ListeMailsScreen
        }

        composable("reply_screen/{senderEmail}/{objet}",
            arguments = listOf(navArgument("senderEmail") { type = NavType.StringType },navArgument("objet") { type = NavType.StringType })
        ) { backStackEntry ->
            val senderEmail = backStackEntry.arguments?.getString("senderEmail") ?: "Unknown"
            val objet = backStackEntry.arguments?.getString("objet") ?: "Unknown"
            ReplyScreen(navController, senderEmail= senderEmail, objet=objet) // Pass extracted argument
        }
        // Other screens can be added here
    }
}

fun navigateToScreen(navController: NavController, route: String) {
    navController.navigate(route)
}