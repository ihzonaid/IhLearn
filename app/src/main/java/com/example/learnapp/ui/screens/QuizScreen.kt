package com.example.learnapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.learnapp.MainActivityViewModel
import com.example.learnapp.data.model.LessonState
import com.example.learnapp.ui.components.IntroduceAlphabet
import com.example.learnapp.ui.components.MatchingLowerUpperCase
import com.example.learnapp.ui.components.MyProgressBar
import com.example.learnapp.ui.components.TapWord
import com.example.learnapp.ui.components.TapWordStartWithLetter


@Composable
fun QuizScreen(
    lessonViewModel: MainActivityViewModel = viewModel(),
    navController: NavHostController
){
    val currentLessonState by lessonViewModel.currentLessonState.collectAsState()
    val context = LocalContext.current


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            MyProgressBar(navController = navController)

            when (currentLessonState) {
                is LessonState.IntroduceAlphabetState -> {
                    IntroduceAlphabet((currentLessonState as LessonState.IntroduceAlphabetState).alphabets)
                }
                is LessonState.TapWordStartWithLetterState -> {
                    val tapWordStartWithState = currentLessonState as LessonState.TapWordStartWithLetterState
                    TapWordStartWithLetter(
                        words = tapWordStartWithState.words,
                        correctWords = tapWordStartWithState.correctWord,
                    )
                }

                is LessonState.MatchingLowerUpperCaseState -> {
                    val alphabets = (currentLessonState as LessonState.MatchingLowerUpperCaseState).alphabets
                    MatchingLowerUpperCase(alphabets)
                }
                is LessonState.TapWordState -> {
                    val tapWordState = currentLessonState as LessonState.TapWordState
                    TapWord(words = tapWordState.words, correctWord = tapWordState.words[tapWordState.answerIdx])
                }
                else -> {

                }


            }


        }
    }
}
