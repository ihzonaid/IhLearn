package com.example.learnapp.ui.components

import androidx.compose.animation.core.MutableTransitionState
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnapp.ui.theme.LearnAppTheme
import kotlin.math.roundToInt

@Composable
fun MatchingLowerUpperCase(alphabet: List<String>) {
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
            Spacer(modifier = Modifier.width(120.dp))
            AlphabetBox(alphabet[0].uppercase())
            Spacer(modifier = Modifier.width(80.dp))
            AlphabetBox(alphabet[1].uppercase())
        }

        Spacer(modifier = Modifier
            .height(200.dp)
            .fillMaxWidth())

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            DraggableAlphabetBox(alphabet = alphabet[0], 100f, 100f, 40.dp)
            AlphabetBox(alphabet[0])
            AlphabetBox(alphabet[1])
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
    targetSize: Dp
    ) {
    var offsetX = remember { mutableStateOf(0f) }
    var offsetY = remember { mutableStateOf(0f) }

    var transitionState = remember { MutableTransitionState(false) }

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
                        val isOverTarget = offsetX.value >= targetOffsetX && offsetY.value >= targetOffsetY &&
                                offsetX.value <= targetOffsetX + targetSize.toPx() &&
                                offsetY.value <= targetOffsetY + targetSize.toPx()

                        if (isOverTarget) {
                            offsetX.value = targetOffsetX
                            offsetY.value = targetOffsetY
                        }
                        else {
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


