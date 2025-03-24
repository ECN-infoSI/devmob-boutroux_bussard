package com.centrale.simplemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.centrale.simplemail.screens.MailViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.centrale.simplemail.data.DataSource

/**
 * Class that is called on startup and that launches the navhost.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavHost() // Launch the NavHost composable
        }
    }
}

/**
 * Composable that takes care of every route in the app.
 */
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
            ) // Navigate to ReplyScreen
        }

        composable(route = DataSource.Routes.route_parametres) {
            // For now the parametres screen is empty.
            ParametresScreen(
                navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to ParametresScreen
        }

        composable(route = DataSource.Routes.route_retour) {
            ListeMailsScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to ListeMailsScreen
        }

        composable(route = DataSource.Routes.route_envoyer) {
            // fake route that will later send an email to the specified receiver.
            EcritureScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to EcritureScreen
        }

        composable(route = DataSource.Routes.route_joindre) {
            // fake route that will later be used to add a document to the mail.
            EcritureScreen(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier,
            ) // Navigate to EcritureScreen
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