package com.example.learnapp.data.model

import kotlinx.coroutines.flow.MutableStateFlow

val lessons: MutableStateFlow<List<LessonState>> = MutableStateFlow(
    listOf(
        LessonState.TapWordState(words = listOf("apple", "banana", "cherry", "vong"), answerIdx = 1),
        LessonState.IntroduceAlphabetState(alphabets = listOf("A", "B", "C", "D")),
        LessonState.MatchingLowerUpperCaseState(alphabets = listOf("a", "b", "c")),
        LessonState.TapWordState(words = listOf("apple", "banana", "cherry", "vong"), answerIdx = 1)
    )
)