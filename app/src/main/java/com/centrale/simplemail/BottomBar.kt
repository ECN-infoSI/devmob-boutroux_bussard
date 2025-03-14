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

// Convert BottomBar to an object for easy reuse
object BottomBar {
    @Composable
    fun Show(
        top: @Composable () -> Unit, // Composable content above the bottom bar
        buttons: List<TypeButton>, // List of buttons to display
        modifier: Modifier = Modifier
    ) {
        Scaffold(
            bottomBar = {
                Bar(buttons = buttons) // Pass the list of buttons to Bar
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

    @Composable
    fun Bar(buttons: List<TypeButton>, modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(110.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            buttons.forEach { typeButton ->
                Button(
                    onClick = { /* Handle click event */ },
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
}

// Move TypeButton outside of BottomBar for easier access
enum class TypeButton(val labelResId: Int) {
    Retour(R.string.retour),
    Joindre(R.string.joindre),
    Envoyer(R.string.envoyer),
    Revenir(R.string.revenir_liste_mail),
    Repondre(R.string.repondre),
    Supprimer(R.string.supprimer),
    EnvoyerMail(R.string.envoyer_mail),
    Parametres(R.string.parametres)
}