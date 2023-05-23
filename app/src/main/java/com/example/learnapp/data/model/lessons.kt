package com.example.learnapp.data.model


val lessons: List<LessonState> = listOf(
    LessonState.TapWordStartWithLetterState(words = listOf("vong", "cong"), correctWord = listOf("vong","cong") ),
    LessonState.TapWordState(words = listOf("apple", "banana", "cherry", "vong"), answerIdx = 1),
    LessonState.TapWordStartWithLetterState(words = listOf("vong", "cong"), correctWord = listOf("vong","cong"), ),
    LessonState.IntroduceAlphabetState(alphabets = listOf("A", "B", "C", "D")),
    LessonState.MatchingLowerUpperCaseState(alphabets = listOf("a", "b")),
    LessonState.TapWordState(words = listOf("apple", "banana", "cherry", "vong"), answerIdx = 1)
)
