package com.example.learnapp.data.model

val lessons: List<LessonState> = listOf(
    LessonState.TapWordState(words = listOf("apple", "banana", "cherry", "vong"), answerIdx = 1),
    LessonState.IntroduceAlphabetState(alphabets = listOf("A", "B", "C", "D")),
    LessonState.MatchingLowerUpperCaseState(alphabets = listOf("a", "b", "c"))
)