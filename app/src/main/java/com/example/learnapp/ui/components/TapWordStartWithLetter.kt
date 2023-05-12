package com.example.learnapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnapp.R
import com.example.learnapp.ui.theme.LearnAppTheme
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TapWordStartWithLetter() {
    val vector: Painter = painterResource(id = R.drawable.ic_launcher_background)
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(vector, contentDescription = "My Vector Image",
            Modifier
                .width(200.dp)
                .height(200.dp))
        Row(
            Modifier.padding(20.dp)
        ){
            Word("Duck")
            Word("Desk")
            Word("Cat")

        }

    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun Word(text: String,modifier: Modifier = Modifier) {
    Surface(
        onClick = {},
        Modifier.padding(5.dp),
        shape = RoundedCornerShape(8.dp),
        tonalElevation = 3.dp,
        shadowElevation = 3.dp,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                MyProgressBar()
                TapWordStartWithLetter()
            }
        }
    }
}