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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import com.centrale.simplemail.screens.MailViewModel


@Composable
fun EcritureScreen(
    navController: NavController,
    viewModel: MailViewModel,
    modifier: Modifier,
) {
    val uiState = viewModel.uiState.collectAsState()
    // Your UI content for the LectureScreen
    BottomBar.Show(
        top= {
            ShowMail(
                mail = uiState.value.contenu,
                destinataire = uiState.value.destinataire,
                objet = uiState.value.objet,
                viewModel = viewModel,
                modifier = modifier
            )
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
    LaunchedEffect(Unit) {
        viewModel.prepareReply() // Exécute `prepareReply()` une seule fois lors de la première composition
    }
    val uiState = viewModel.uiState.collectAsState() // ✅ Observer les changements
    Column {
        // Your UI content for the LectureScreen
        BottomBar.Show(
            top= {
                ShowMail(
                    mail = uiState.value.contenu,
                    destinataire = uiState.value.destinataire,
                    objet = uiState.value.objet,
                    viewModel = viewModel,
                    modifier = modifier
                )
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
    viewModel: MailViewModel,
    mail : String,
    destinataire : String,
    objet : String,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState()
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Aligne les éléments verticalement
        ) {
            Text(
                text = "Objet : ",
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Left
            )
            TextField(
                value = uiState.value.objet,
                onValueChange = { viewModel.setObjet(it) },
                modifier = Modifier
                    .weight(1f), // Permet au champ de texte de prendre tout l’espace restant
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Left
                ),
                singleLine = true, // Empêche les retours à la ligne
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Aligne les éléments verticalement
        ){
            Text(
                text = "Destinataire :  ",
                fontSize = 18.sp,
                lineHeight = 22.sp,
                textAlign = TextAlign.Left
            )
            TextField(
                value = uiState.value.destinataire,
                onValueChange = { viewModel.setDestinataire(it) },
                modifier = Modifier
                    .weight(1f), // Permet au champ de texte de prendre tout l’espace restant
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Left,
                ),
                singleLine = true, // Empêche les retours à la ligne
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
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
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                val uiState = viewModel.uiState.collectAsState()
                TextField(
                    value = uiState.value.contenu,
                    onValueChange = {
                        viewModel.setContenu(it)
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
                    ),
                    textStyle = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 30.sp,
                        textAlign = TextAlign.Left,
                    ),
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