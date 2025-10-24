@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pooperapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pooperapp.ui.theme.PooperAppTheme
import com.google.android.gms.maps.model.LatLng
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pooperapp.presentation.PooperScreen
import com.example.pooperapp.viewmodels.PooperViewModel
import com.example.pooperapp.viewmodels.viewModelFactory
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PooperAppTheme {
                val viewModel = viewModel<PooperViewModel>(
                    factory = viewModelFactory {
                        PooperViewModel(PooperApp.pooperModule)
                    }
                )
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    PooperScreen(viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    PooperAppTheme {
        // MyApp()
    }
}