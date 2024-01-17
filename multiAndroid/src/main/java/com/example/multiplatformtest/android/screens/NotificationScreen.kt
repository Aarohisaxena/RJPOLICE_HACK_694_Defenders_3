package com.example.multiplatformtest.android.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun NotificationScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            for (i in 1..30) {
                item {
                    Text(text = "hellllllllloooooo")
                }
            }
        }
    }
}
