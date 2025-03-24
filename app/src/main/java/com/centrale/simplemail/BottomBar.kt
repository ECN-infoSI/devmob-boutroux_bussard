package com.centrale.simplemail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.centrale.simplemail.data.DataSource
import com.centrale.simplemail.screens.MailViewModel

private const val s = "previous_screen"

/**
 * BottomBar is an object for easy reuse
 * It is used throughout the app to display the bar at the bottom of the screen.
 * It calls routes depending on the button the user clicks.
 * Put everything else in the [top] parameter.
 */
object BottomBar {
    @Composable
    fun Show(
        top: @Composable () -> Unit, // Composable content above the bottom bar
        buttons: List<TypeButton>, // List of buttons to display
        navController: NavController,
        viewModel: MailViewModel = viewModel(),
        modifier: Modifier = Modifier
    ) {
        Scaffold(
            bottomBar = {
                Bar(buttons = buttons,
                    navController= navController,
                    viewModel = viewModel,
                ) // Pass the list of buttons to Bar
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                top() // Display the top composable content
            }
        }
    }

    /**
     * displays a bar with buttons.
     * The names and the effects of the buttons will depend on [buttons].
     */
    @Composable
    fun Bar(
        buttons: List<TypeButton>,
        navController: NavController,
        viewModel: MailViewModel,
        modifier: Modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(110.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            buttons.forEach { typeButton ->
                Button(
                    onClick = {
                        HandleButtonClick(
                            button = typeButton,
                            navController = navController,
                            viewModel = viewModel
                        ) }, // Call navigation function
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    shape = RectangleShape
                ) {
                    Text(
                        stringResource(id = typeButton.labelResId),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

    /**
     * Function to handle navigation based on TypeButton.
     * It handles only the navigation that is linked to the bottom bar.
     */
    fun HandleButtonClick(
        button: TypeButton,
        navController: NavController,
        viewModel: MailViewModel,
        ) {
        when (button) {
            TypeButton.Retour -> {
//                viewModel.logAction("Retour")
                navController.navigate(DataSource.Routes.route_retour)
            }
            TypeButton.Joindre -> {
//                viewModel.prepareAttachment()
                navController.navigate(DataSource.Routes.route_joindre)
            }
            TypeButton.Envoyer -> {
//                viewModel.sendMail()
                navController.navigate(DataSource.Routes.route_envoyer)
            }
            TypeButton.RevenirListeMail -> {
//                viewModel.refreshMailList()
                navController.navigate(DataSource.Routes.route_revenir_liste_mail)
            }
            TypeButton.Repondre -> {
                navController.navigate(DataSource.Routes.route_repondre)
            }
            TypeButton.Supprimer -> {
//                viewModel.deleteSelectedMail()
                navController.navigate(DataSource.Routes.route_supprimer)
            }
            TypeButton.EnvoyerMail -> {
//                viewModel.prepareNewMail()
                navController.navigate(DataSource.Routes.route_page_envoyer_mail)
            }
            TypeButton.Parametres -> {
//                viewModel.loadSettings()
                navController.navigate(DataSource.Routes.route_parametres)
            }
        }
    }
}

// Put TypeButton outside of BottomBar for easier access
/**
 * Defines every button that can appear on the bottom bar.
 */
enum class TypeButton(val labelResId: Int) {
    Retour(R.string.retour),
    Joindre(R.string.joindre),
    Envoyer(R.string.envoyer),
    RevenirListeMail(R.string.revenir_liste_mail),
    Repondre(R.string.repondre),
    Supprimer(R.string.supprimer),
    EnvoyerMail(R.string.envoyer_mail),
    Parametres(R.string.parametres)
}

