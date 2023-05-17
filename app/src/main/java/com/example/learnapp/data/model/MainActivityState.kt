package com.example.learnapp.data.model

sealed class LessonState {
    data class IntroduceAlphabetState(val alphabets: List<String>) : LessonState()
    data class TapWordStartWithLetterState(
        val words: List<String>,
        val correctIndex: List<Int>,
        val selectedWord: Int
    ) : LessonState()
    data class MatchingLowerUpperCaseState(val alphabets: List<String>) : LessonState()
    data class TapWordState(val words: List<String>, val answerIdx: Int) : LessonState()
}

data class MainActivityState(
    val lessons: List<LessonState>
)
