/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.centrale.simplemail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.centrale.simplemail.ui.theme.SimpleMailTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.centrale.simplemail.screens.MailViewModel

/**
 * Composant qui affiche la page de lecture d'un mail
 */
@Composable
fun LectureScreen(
    navController: NavController,
    viewModel: MailViewModel,
    modifier: Modifier = Modifier,
    onOpenMail : (String) -> Unit = {},
    ) {
    BottomBar.Show(
        top= {
            SelectOptionScreen(
                modifier = modifier,
                viewModel = viewModel,
            )
        },
        buttons = listOf(TypeButton.RevenirListeMail, TypeButton.Repondre, TypeButton.Supprimer), // Specify the buttons to display
        navController= navController,
        viewModel = viewModel,
        modifier = Modifier,
    )
}

/**
 * Displays the email to read.
 * It shows an object, an expediter and a receiver.
 */
@Composable
fun SelectOptionScreen(
    viewModel: MailViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState() // Observer les changements
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = uiState.value.objet,
            fontSize = 20.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Left,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "De :  ",
                fontSize = 15.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Left
            )
            Text(
                text = uiState.value.expediteur,
                fontSize = 15.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Left,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
        }
        HorizontalDivider(
            thickness = 2.dp
        )
        Text(
            text = uiState.value.contenu,
            fontSize = 30.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Left
        )
    }
}

/**
 * Preview for the reading an email.
 */
@Preview
@Composable
fun SelectOptionPreview() {
    SimpleMailTheme {
        SelectOptionScreen(
            modifier = Modifier.fillMaxHeight(),
            viewModel = MailViewModel()
        )
    }
}
