package com.example.learnapp.data.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class LessonState {

    data class IntroduceAlphabetState(val alphabets: List<String>) : LessonState()
    data class TapWordStartWithLetterState(
        val words: List<String>,
        val correctWord: List<String>,
    ) : LessonState()
    data class MatchingLowerUpperCaseState(val alphabets: List<String>) : LessonState()
    data class TapWordState(val words: List<String>, val answerIdx: Int) : LessonState()
}

data class MainActivityState(
    val lessons: List<LessonState>
)
