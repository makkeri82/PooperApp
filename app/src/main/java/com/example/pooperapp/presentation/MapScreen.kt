package com.example.pooperapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pooperapp.viewmodels.LocationUiState
import com.example.pooperapp.viewmodels.PooperViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(
    pooperViewModel: PooperViewModel,
    locationPermission: MultiplePermissionsState
) {
    val locationState by pooperViewModel.locationUiState.collectAsState()

    when (val state = locationState) {
        is LocationUiState.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
        is LocationUiState.Success -> {
            Map(
                modifier = Modifier.fillMaxSize(),
                pooperViewModel = pooperViewModel,
                startLocation = state.location,
                locationPermission = locationPermission
            )
        }
        is LocationUiState.Error -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.message,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Map(
    modifier: Modifier = Modifier,
    pooperViewModel: PooperViewModel,
    startLocation: LatLng,
    locationPermission: MultiplePermissionsState
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Maps(
            modifier = Modifier.fillMaxSize(),
            startLocation = startLocation,
            poopData = pooperViewModel.poops,
            permissions = locationPermission
        )
        PooperButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            onClick = { pooperViewModel.addPoop() }
        )
    }
}