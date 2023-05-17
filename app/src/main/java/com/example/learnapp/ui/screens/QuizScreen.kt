package com.example.learnapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnapp.MainActivityViewModel
import com.example.learnapp.data.model.LessonState
import com.example.learnapp.ui.components.IntroduceAlphabet
import com.example.learnapp.ui.components.MatchingLowerUpperCase
import com.example.learnapp.ui.components.MyProgressBar
import com.example.learnapp.ui.components.TapWord
import com.example.learnapp.ui.components.TapWordStartWithLetter


@Composable
fun QuizScreen(
    lessonViewModel: MainActivityViewModel = viewModel()
){
    val currentIndex by lessonViewModel.currentIndex.collectAsState()
    val currentLessonState = lessonViewModel.getCurrentLessonState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column {
            MyProgressBar()


            when (currentLessonState) {
                is LessonState.IntroduceAlphabetState -> {
                    IntroduceAlphabet((currentLessonState as LessonState.IntroduceAlphabetState).alphabets)
                }
                is LessonState.TapWordStartWithLetterState -> {
                    val tapWordState = currentLessonState as LessonState.TapWordStartWithLetterState
                    TapWordStartWithLetter(
                        words = tapWordState.words,
                    )
                }

                is LessonState.MatchingLowerUpperCaseState -> {
                    MatchingLowerUpperCase()
                }
                is LessonState.TapWordState -> {
                    val tapWordState = currentLessonState as LessonState.TapWordState
                    TapWord(words = tapWordState.words, correctWord = tapWordState.words[tapWordState.answerIdx])
                }
                else -> {

                }


            }

//            when (index) {
//                0 -> TapWord()
//                1 -> IntroduceAlphabet(index, setIndex)
//                2 -> TapWordStartWithLetter(index, setIndex)
//            }

        }
    }
}
