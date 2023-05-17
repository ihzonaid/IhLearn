package com.example.learnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.learnapp.ui.components.IntroduceAlphabet
import com.example.learnapp.ui.components.MyProgressBar
import com.example.learnapp.ui.components.TapWord
import com.example.learnapp.ui.components.TapWordStartWithLetter
import com.example.learnapp.ui.screens.QuizScreen
import com.example.learnapp.ui.theme.LearnAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val (index, setIndex) = remember { mutableStateOf(0) }
            LearnAppTheme {
                // A surface container using the 'background' color from the theme
                QuizScreen()

            }
        }
    }
}



