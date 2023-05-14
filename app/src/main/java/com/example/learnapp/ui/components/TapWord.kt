package com.example.learnapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnapp.ui.theme.LearnAppTheme

@Composable
fun TapWord(){
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.height(200.dp))
        IconButton(onClick = { /*TODO*/ },
            Modifier
                .size(100.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                Icons.Filled.Call,
                contentDescription = "call",
                Modifier.size(30.dp),
                tint = MaterialTheme.colorScheme.onPrimary,
            )
            
        }

        Spacer(modifier = Modifier.height(30.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            AlphabetBox()
            AlphabetBox()
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            AlphabetBox()
            AlphabetBox()
        }

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
            }
            TapWord()
        }
    }
}