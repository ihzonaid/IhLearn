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
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun MatchingLowerUpperCase(alphabets: List<String>) {
    var (resIdx, setIdx)  = remember {
         mutableStateOf(0)
    }

    var (correct,setCorrect) = remember {
        mutableStateOf(true)
    }

    var (goalOffset,setGoalOffset) = remember {
        mutableStateOf(Offset.Zero)
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
                AlphabetBox(alphabets[resIdx].uppercase(), setGoalOffset)
                Text(text = goalOffset.x.toString() + "/" + goalOffset.y.toString())
            }
        }

        Spacer(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth())

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            alphabets.forEach { alphabet ->
                DraggableAlphabetBox(alphabet = alphabet, 200.dp,correct, setCorrect, goalOffset, ansAlphabet=alphabets[resIdx])
            }
        }

    }
}

@Composable
fun AlphabetBox(alphabet: String,
                setGoalOffset: (Offset) -> Unit,
                modifier: Modifier = Modifier,
) {

    Box(
        modifier = Modifier
            .size(130.dp)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.outline)
            .onGloballyPositioned { coordinates ->
                setGoalOffset(coordinates.positionInRoot())
            }
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
    targetSize: Dp,
    correct: Boolean,
    setCorrect: (Boolean) -> Unit,
    goalOffset: Offset,
    ansAlphabet: String,
    ) {
    var offsetX = remember { mutableStateOf(0f) }
    var offsetY = remember { mutableStateOf(0f) }

    var transitionState = remember { MutableTransitionState(false) }

    var targetOffset by remember {
        mutableStateOf(Offset.Zero)

    }


    var text by remember {
        mutableStateOf("value")
    }

    AnimatedVisibility(visible = correct) {
        Box(
            modifier = Modifier
                .size(130.dp)
                .onGloballyPositioned { coordinate ->
                    targetOffset = goalOffset - coordinate.positionInRoot()
                }
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
                                offsetX.value >= (targetOffset.x - targetSize.toPx()) && (offsetY.value >= targetOffset.y - targetSize.toPx()) &&
                                        offsetX.value <= targetOffset.x + targetSize.toPx() &&
                                        offsetY.value <= targetOffset.y + targetSize.toPx()


                            if (isOverTarget && alphabet == ansAlphabet) {
                                offsetX.value = targetOffset.x
                                offsetY.value = targetOffset.y
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

                        //
                        text = (targetOffset).toString()

                    }
                }

        ) {
            Text(
                text = alphabet,
                modifier = Modifier.align(Alignment.Center),
                style = TextStyle(fontSize = 80.sp, fontWeight = FontWeight.Bold)
            )
            Text(text=text)
        }
    }

}


