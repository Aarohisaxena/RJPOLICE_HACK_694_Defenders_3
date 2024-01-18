package com.example.multiplatformtest.android.screens

import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.core.state.Reference
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.multiplatformtest.android.R
import com.google.firebase.storage.FirebaseStorage
import java.io.IOException
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@RequiresApi(Build.VERSION_CODES.P)
@Preview
@Composable
fun NotificationScreen() {

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
//            for (i in 1..30) {
            item {
                DisplayImage()
            }
//            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun DisplayImage() {
    val context = LocalContext.current
    val storageRef = FirebaseStorage.getInstance().reference.child("violenceDummy.jpg")
    var imageUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var image by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(storageRef) {
        storageRef.downloadUrl.addOnSuccessListener { uri ->
            imageUri = uri
            Log.d("fburi",imageUri.toString())
        }
    }//    val image by FirebaseStorage.getInstance().getReference(imageUrl).get().observeAsState()


    val painter = rememberAsyncImagePainter(imageUri)
    Log.d("fburi",painter.toString())
    Image(modifier = Modifier.size(200.dp), painter = painter, contentDescription =null )
//    LaunchedEffect(imageUri) {
//        if (imageUri != null) {
//            try {
//                val bitmap = ImageDecoder.decodeBitmap(
//                    ImageDecoder.createSource(
//                        context.contentResolver,
//                        imageUri!!
//                    )
//                )
//                image = bitmap.asImageBitmap()
//            } catch (e: IOException) {
//                // Handle error
//            }

//            imageUri = null // Clear the state to prevent re-fetching
//        }
//    Image(painter = rememberAsyncImagePainter)
    }

//    Image(
//        (Imagimage?.asAndroidBitmap()),
//        "Image from Firebase Storage",
//    )

