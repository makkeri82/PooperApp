@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pooperapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pooperapp.ui.theme.PooperAppTheme
import com.google.android.gms.maps.model.LatLng
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            PooperAppTheme {
                    MyApp()
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val ouluLocation = LatLng(65.0121, 25.4651)

    PooperAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            PooperScreen(modifier,ouluLocation)
        }
    }

//    Box(
//        modifier = modifier.fillMaxSize()
//    ) {
//        Maps(
//            modifier = Modifier.fillMaxSize(),
//            location = ouluLocation,
//            poopData = PoopData().getPoopData()
//        )
//        PooperButton(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(16.dp),
//            onClick = {}
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    PooperAppTheme {
        MyApp()
    }
}