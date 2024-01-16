package com.example.multiplatformtest.android

import HomeScreen
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.multiplatformtest.android.app.PoliceApp
import com.example.multiplatformtest.android.screens.SignUpScreen
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
            FirebaseMessaging.getInstance().token
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w("newtoken", "getInstanceId failed", task.exception)
                        return@addOnCompleteListener
                    }

                    // Get the FCM token
                    val token = task.result
                    Log.d("newtoken", "FCM Token: $token")
                }
//                PoliceApp()
//            }
        }
    }
}


//@Composable
//fun GreetingView(text: String) {
//    Text(text = text)
//}