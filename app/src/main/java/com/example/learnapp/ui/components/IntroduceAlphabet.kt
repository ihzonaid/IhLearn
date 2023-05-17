package com.example.learnapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.learnapp.R

@Composable
fun IntroduceAlphabet(alphabets: List<String>) {
    val vector: Painter = painterResource(id = R.drawable.ic_launcher_background)
    val (buttonClicked, setButtonClicked) = remember { mutableStateOf(false) }

    val color =  if (buttonClicked) { Color.Black } else {Color.Blue}
    val size = if (buttonClicked) { 100.dp } else { 50.dp }


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
        Alphabet(listOf("A", "B"))
        Spacer(Modifier.weight(1f))
        Box(Modifier.size(size).background(color))

        MyButton(onClick = { setButtonClicked(!buttonClicked);  })

    }
}