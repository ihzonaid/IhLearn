package com.example.learnapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun MatchingLowerUpperCase(alphabet: List<String>) {
    var (correct,setCorrect) = remember {
        mutableStateOf(true)
    }
    Column() {
        Spacer(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth())
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            AnimatedVisibility(visible = correct) {
                AlphabetBox(alphabet[0].uppercase())
            }
        }

        Spacer(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth())

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            alphabet.forEach { ch ->
                DraggableAlphabetBox(alphabet = ch, 275f, -1000f, 200.dp,correct, setCorrect)
            }
        }

    }
}

@Composable
fun AlphabetBox(alphabet: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(130.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.outline)

        ){
        Text(text = alphabet,
            modifier = Modifier.align(Alignment.Center),
            style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
        )
    }

}

@Composable
fun DraggableAlphabetBox(
    alphabet: String,
    targetOffsetX: Float,
    targetOffsetY: Float,
    targetSize: Dp,
    correct: Boolean,
    setCorrect: (Boolean) -> Unit
    ) {
    var offsetX = remember { mutableStateOf(0f) }
    var offsetY = remember { mutableStateOf(0f) }

    var transitionState = remember { MutableTransitionState(false) }

    var text by remember {
        mutableStateOf("value")
    }

    AnimatedVisibility(visible = correct) {
        Box(
            modifier = Modifier
                .size(130.dp)
                .offset {
                    IntOffset(
                        x = offsetX.value.roundToInt(),
                        y = offsetY.value.roundToInt()
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = {
                            transitionState.targetState = true
                        },
                        onDragEnd = {
                            transitionState.targetState = false
                            val isOverTarget =
                                offsetX.value >= (targetOffsetX-targetSize.toPx()) && (offsetY.value >= targetOffsetY - targetSize.toPx()) &&
                                        offsetX.value <= targetOffsetX + targetSize.toPx() &&
                                        offsetY.value <= targetOffsetY + targetSize.toPx()


                            if (isOverTarget) {
                                offsetX.value = targetOffsetX
                                offsetY.value = targetOffsetY
//                                setCorrect(false)

                            } else {
                                offsetX.value = 0f
                                offsetY.value = 0f
                            }
                        }
                    ) { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX.value += dragAmount.x
                        offsetY.value += dragAmount.y

                    }
                }

        ) {
            Text(
                text = alphabet,
                modifier = Modifier.align(Alignment.Center),
                style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
            )
        }
    }

}


