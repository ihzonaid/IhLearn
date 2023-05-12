package com.example.learnapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.learnapp.R

@Composable
fun IntroduceAlphabet() {
    val vector: Painter = painterResource(id = R.drawable.ic_launcher_background)
    val (buttonClicked, setButtonClicked) = remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        Arrangement.Center,
        Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(.3f))
        Image(vector, contentDescription = "My Vector Image",)
        Alphabet()
        Spacer(Modifier.weight(1f))
        MyButton(onClick = { setButtonClicked(true) })

    }
}