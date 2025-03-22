package com.bt.composelens_core

import android.util.Log
import androidx.compose.runtime.*

private val recompositionCounts = mutableStateMapOf<String, Int>()

@Composable
fun DebugComposableWrapper(
    tag: String,
    content: @Composable () -> Unit
) {
    var count by remember { mutableIntStateOf(0) }

    SideEffect {
        count++
        recompositionCounts[tag] = count
        Log.d("ComposeLens", "[$tag] recomposed $count times")
    }

    CompositionLocalProvider(LocalDebugTag provides tag) {
        content()
    }
}

val LocalDebugTag = compositionLocalOf { "Unknown" }

fun getAllRecompositionStats(): Map<String, Int> = recompositionCounts
