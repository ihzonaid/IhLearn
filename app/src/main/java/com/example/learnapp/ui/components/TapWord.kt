package com.example.learnapp.ui.components

import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnapp.MainActivityViewModel
import com.example.learnapp.R
import com.example.learnapp.ui.theme.LearnAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun TapWord(words: List<String>, correctWord: String){

    val myViewModel: TapWordViewModel = viewModel()
    val context = LocalContext.current


    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.height(100.dp))
        IconButton(onClick = {
            myViewModel.textToSpeech(context)
        },
            Modifier
                .size(100.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                Icons.Filled.Call,
                contentDescription = "call",
                Modifier.size(30.dp),
                tint = MaterialTheme.colorScheme.onPrimary,
            )
            
        }

        Spacer(modifier = Modifier.height(30.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            WordBox(words[0], correctWord)
            WordBox(words[1], correctWord)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            WordBox(words[3], correctWord)
            WordBox(words[2], correctWord)
        }
    }

}







@Composable
fun WordBox(word: String = "Word", correctWord: String,
            lessonViewModel: MainActivityViewModel = viewModel()) {
    val context = LocalContext.current
    val coroutineScope = CoroutineScope(Dispatchers.Main)

    val animatableOffset = remember { Animatable(0f) }
    val animationScope = rememberCoroutineScope()

    val movementDistance = 10.dp

    val mediaPlayer = remember { MediaPlayer.create(context, R.raw.negative_beeps) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }

    val handleClick: () -> Unit = {
        println(word + correctWord)

        if (word == "apple") {
            lessonViewModel.incrementIndex()
            Toast.makeText(context, "Index" + lessonViewModel.currentIndex.value, Toast.LENGTH_SHORT).show()

        } else {
            animationScope.launch {
                animatableOffset.animateTo(-movementDistance.value, animationSpec = spring())
                animatableOffset.animateTo(movementDistance.value, animationSpec = spring())
                animatableOffset.animateTo(0f, animationSpec = spring())
                mediaPlayer.start()
            }
        }

    }

    Box(
        modifier = Modifier
            .size(130.dp)
            .padding(5.dp)
            .clickable(onClick = handleClick)
            .offset(
                x = animatableOffset.value.dp,
                y = 0.dp
            )
    ){
        Box (
            Modifier
                .fillMaxSize()
                .border(width = 2.dp, color = MaterialTheme.colorScheme.outline)
        ) {
            Text(text = word,
                modifier = Modifier.align(Alignment.Center),
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                MyProgressBar()
            }
            TapWord(listOf("apple", "vong", "cong", "black"), "apple")
        }
    }
}



