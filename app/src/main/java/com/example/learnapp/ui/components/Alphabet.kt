package com.example.learnapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Alphabet(){
    Row() {
        Text(text = "A", Modifier.padding(20.dp),
            style = TextStyle(fontSize = 100.sp, fontWeight = FontWeight.Bold)
        )
        Text(text = "A", Modifier.padding(20.dp),
            style =  TextStyle(fontSize = 100.sp, fontWeight = FontWeight.Bold)
        )
    }
}