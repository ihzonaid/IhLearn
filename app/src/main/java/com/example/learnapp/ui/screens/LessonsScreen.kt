package com.example.learnapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonsScreen(onNavigateToLesson: () -> Unit){
    Column() {
        LazyColumn() {
            items(5) { index ->
                Surface(onClick = onNavigateToLesson) {
                    Text(text = "Lesson $index",)
                }
            }
        }

    }
}