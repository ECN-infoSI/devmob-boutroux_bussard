package com.centrale.simplemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getString
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.centrale.simplemail.screens.MailViewModel
import com.centrale.simplemail.ui.theme.SimpleMailTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.centrale.simplemail.data.DataSource

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
    val viewModel: MailViewModel = viewModel() // Obtain ViewModel

    // Define your NavHost
    NavHost(navController = navController, startDestination = "lecture_screen") {
        composable(DataSource.Routes.lecture) {
            viewModel.setObjet("Bonjour mémé")
            viewModel.setExpediteur("Petit fils n°4")
            viewModel.setContenu("Comment ça va mamie ?")
            LectureScreen(
                navController,
                onOpenMail = {
                    viewModel.setObjet(it)
                    viewModel.setExpediteur(it)
                },
                modifier = Modifier,
                viewModel = viewModel
            ) // Navigate to LectureScreen
        }
        composable(DataSource.Routes.route_page_envoyer_mail) {
            viewModel.resetMail()
            EcritureScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
                ) // Navigate to EcritureScreen
        }
        composable(DataSource.Routes.route_revenir_liste_mail) {
            ListeMailsScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to ListeMailsScreen
        }

        composable(route = DataSource.Routes.route_repondre) {
            ReplyScreen(
                navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Pass extracted argument
        }

        composable(route = DataSource.Routes.route_parametres) {
            ParametresScreen(
                navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Pass extracted argument
        }

        composable(route = DataSource.Routes.route_retour) {
            ListeMailsScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to ListeMailsScreen
        }

        composable(route = DataSource.Routes.route_envoyer) {
            EcritureScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to ListeMailsScreen
        }

        composable(route = DataSource.Routes.route_joindre) {
            EcritureScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to ListeMailsScreen
        }

        composable(route = DataSource.Routes.route_supprimer) {
            ListeMailsScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to ListeMailsScreen
        }
        // Other screens can be added here
    }
}

fun navigateToScreen(navController: NavController, route: String) {
    navController.navigate(route)
}