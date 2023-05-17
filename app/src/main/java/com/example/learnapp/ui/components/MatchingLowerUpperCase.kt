package com.example.learnapp.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnapp.ui.theme.LearnAppTheme

@Composable
fun MatchingLowerUpperCase() {
    Column() {
        Spacer(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth())
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.width(120.dp))
            AlphabetBox("A")
            Spacer(modifier = Modifier.width(80.dp))
            AlphabetBox("D")
        }

        Spacer(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth())

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AlphabetBox("A")
            AlphabetBox("D")
        }

        Spacer(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth())

        Row (
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            AlphabetBox("D")
            AlphabetBox("A")
        }


    }

}

@Composable
fun AlphabetBox(alphabet: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(130.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.outline)

        ){
        Text(text = alphabet,
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
        )
    }

}


