package com.bt.composelens_overlay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bt.composelens_core.getAllRecompositionStats
import kotlinx.coroutines.delay

@Composable
fun DebugPanel(
    modifier: Modifier = Modifier
        .padding(8.dp)
        .width(220.dp)
        .background(Color(0xFF1E1E1E).copy(alpha = 0.9f))
) {
    var stats by remember { mutableStateOf(getAllRecompositionStats()) }

    // Refresh verileri her 500ms'de bir
    LaunchedEffect(Unit) {
        while (true) {
            stats = getAllRecompositionStats()
            delay(500)
        }
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        Text(
            text = "🪄 ComposeLens",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))

        if (stats.isEmpty()) {
            Text("No tracked composables", color = Color.Gray)
        } else {
            stats.forEach { (tag, count) ->
                Text(
                    text = "[$tag]: $count recomps",
                    color = Color(0xFF90CAF9),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
