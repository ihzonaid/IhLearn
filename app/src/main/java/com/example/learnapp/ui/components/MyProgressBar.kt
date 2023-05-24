package com.example.learnapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnapp.MainActivityViewModel
import com.example.learnapp.data.model.lessons
import com.example.learnapp.ui.theme.LearnAppTheme

@Composable
fun MyProgressBar(
    modifier: Modifier = Modifier,
    lessonViewModel: MainActivityViewModel = viewModel()
) {

    val currentIndex by lessonViewModel.currentIndex.collectAsState()
    val fillWidth: Float = (currentIndex+1 / lessons.size).toFloat()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "close"
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .height(20.dp)
                .border(
                    brush = Brush.linearGradient(
                        listOf(
                            MaterialTheme.colorScheme.outline,
                            MaterialTheme.colorScheme.outlineVariant
                        )
                    ),
                    width = 2.dp,
                    shape = RoundedCornerShape(0.dp)
                )

        ) {
            Box(
                Modifier
                    .height(18.dp)
                    .fillMaxWidth(fillWidth)
                    .background(MaterialTheme.colorScheme.primary)
                    .clip(RoundedCornerShape(16.dp))
            )
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
        }
    }
}
