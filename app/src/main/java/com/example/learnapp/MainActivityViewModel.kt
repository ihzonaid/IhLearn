package com.example.learnapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.learnapp.data.model.LessonState
import com.example.learnapp.data.model.MainActivityState
import com.example.learnapp.data.model.lessons
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel: ViewModel() {

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: MutableStateFlow<Int> = _currentIndex

    private val _currentLessonState = MutableStateFlow<LessonState>(lessons[0])
    val currentLessonState: MutableStateFlow<LessonState> = _currentLessonState

    fun incrementIndex() {
        val newIndex = (_currentIndex.value + 1) % lessons.size
        _currentIndex.value = newIndex
        _currentLessonState.value = getCurrentLessonState()

    }


    fun getCurrentLessonState(): LessonState {
        val index = currentIndex.value
        return lessons[index]
    }

}