package com.example.multiplatformtest.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.multiplatformtest.android.app.PoliceApp
import com.example.multiplatformtest.android.screens.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyApplicationTheme {
//                PoliceApp()
            SignUpScreen()
//            }
        }
    }
}


//@Composable
//fun GreetingView(text: String) {
//    Text(text = text)
//}