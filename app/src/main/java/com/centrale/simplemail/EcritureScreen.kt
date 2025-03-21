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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.centrale.simplemail.BottomBar.handleButtonClick


@Composable
fun EcritureScreen(navController: NavController) {
    // Your UI content for the LectureScreen
    BottomBar.Show(
        top= {
            ShowMail(mail= "mail", objet="objet")
        },
        buttons = listOf(TypeButton.Retour, TypeButton.Joindre, TypeButton.Envoyer), // Specify the buttons to display
        navController= navController
    )
}

@Composable
fun ReplyScreen(navController: NavController, senderEmail: String, objet: String) {
    Column {
        ShowMail(mail= "$senderEmail", objet="RE: $objet")
        // Add UI for replying to the email
    }
}

@Composable
fun ShowMail(
    mail : String,
    objet : String,
    modifier: Modifier = Modifier
) {
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
                text = "$mail",
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
        Text(
            text = "le contenu du mail reçu \n test",
            fontSize = 30.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun EcritureBar(buttons: List<TypeButton>, navController: NavController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        buttons.forEach { typeButton ->
            Button(
                onClick = { handleButtonClick(typeButton, navController) }, // Call navigation function
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

@Preview(showBackground = true)
@Composable
fun EcriturePreview() {
    val navController= rememberNavController()
    SimpleMailTheme {
        EcritureScreen(navController= navController)
    }
}