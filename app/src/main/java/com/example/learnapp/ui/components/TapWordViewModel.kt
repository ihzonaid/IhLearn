package com.example.learnapp.ui.components


import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TapWordViewModel:ViewModel() {

    private val _state = mutableStateOf(TapWordState())
    val state: State<TapWordState> = _state

    private  var  textToSpeech:TextToSpeech? = null

    fun textToSpeech(context: Context){
        textToSpeech = TextToSpeech(
            context
        ) {
            if (it == TextToSpeech.SUCCESS) {
                textToSpeech?.let { txtToSpeech ->
                    txtToSpeech.setSpeechRate(1.0f)
                    txtToSpeech.speak(
                        "Hello Word",
                        TextToSpeech.QUEUE_ADD,
                        null,
                        null
                    )
                }
            }
        }
    }
}