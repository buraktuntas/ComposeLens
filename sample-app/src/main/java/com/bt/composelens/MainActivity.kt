package com.bt.composelens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bt.composelens.ui.theme.ComposeLensTheme
import com.bt.composelens_overlay.DebugPanel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLensTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LoginScreen()

        DebugPanel(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(82.dp)
        )
    }
}

