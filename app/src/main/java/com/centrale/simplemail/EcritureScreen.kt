package com.centrale.simplemail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.centrale.simplemail.ui.theme.SimpleMailTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.centrale.simplemail.screens.MailViewModel


@Composable
fun EcritureScreen(
    navController: NavController,
    viewModel: MailViewModel,
    modifier: Modifier,
) {
    // Your UI content for the LectureScreen
    BottomBar.Show(
        top= {
            ShowMail(mail= "mail", destinataire="destinataire" ,objet="objet")
        },
        buttons = listOf(TypeButton.Retour, TypeButton.Joindre, TypeButton.Envoyer), // Specify the buttons to display
        navController= navController,
        viewModel = viewModel,
        modifier = modifier,
    )
}

@Composable
fun ReplyScreen(
    navController: NavController,
    viewModel: MailViewModel,
    modifier: Modifier,
) {
    val uiState = viewModel.uiState.collectAsState() // ✅ Observer les changements
    Column {
        // Your UI content for the LectureScreen
        BottomBar.Show(
            top= {
                ShowMail(mail=uiState.value.contenu, destinataire=uiState.value.destinataire ,objet=uiState.value.objet)
                // Add UI for replying to the email
            },
            buttons = listOf(TypeButton.Retour, TypeButton.Joindre, TypeButton.Envoyer), // Specify the buttons to display
            navController= navController,
            viewModel = viewModel,
            modifier = modifier,
        )
    }
}

@Composable
fun ShowMail(
    mail : String,
    destinataire : String,
    objet : String,
    modifier: Modifier = Modifier
) {
    var writtingText by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Objet : ",
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Left,
            )
            Text(
                text = "$objet",
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Left,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Destinataire :  ",
                fontSize = 15.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Left
            )
            Text(
                text = "$destinataire",
                fontSize = 15.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Left,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
        }
        HorizontalDivider(
            thickness = 2.dp,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState(), enabled = true)
                .imePadding(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "test d'un contenu \n sur plusieurs lignes",
                fontSize = 30.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Left
            )
            HorizontalDivider(
                thickness = 2.dp,
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                TextField(
                    value = writtingText,
                    onValueChange = {
                        writtingText = it
                    },
                    modifier = modifier
                        .fillMaxWidth(),

                    placeholder = { Text("écrivez votre mail ici") },
                    maxLines = 2000,

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EcriturePreview() {
    val navController= rememberNavController()
    SimpleMailTheme {
        EcritureScreen(
            navController = navController,
            viewModel = MailViewModel(),
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepondrePreview() {
    val navController= rememberNavController()
    SimpleMailTheme {
        ReplyScreen(
            navController = navController,
            viewModel = MailViewModel(),
            modifier = Modifier,
        )
    }
}