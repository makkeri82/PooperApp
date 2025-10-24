package com.example.pooperapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pooperapp.data.PoopMarkerData
import com.example.pooperapp.viewmodels.PooperViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PooperScreen(
    pooperViewModel: PooperViewModel,
    modifier: Modifier = Modifier
) {

    val ouluLocation = LatLng(65.0121, 25.4651)

    val newPoop =
        PoopMarkerData(
            id = 99,
            location = LatLng(65.1299, 25.3490),
            description = "Good"
        )

    // ADD PERMISSIONS
    val locationPermission = rememberMultiplePermissionsState(
        permissions = listOf(
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.ACCESS_COARSE_LOCATION"
        )
    )

    // REQUEST PERMISSIONS DIALOG
    LaunchedEffect(key1 = locationPermission.permissions) {
        locationPermission.launchMultiplePermissionRequest()
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Maps(
            modifier = Modifier.fillMaxSize(),
            location = ouluLocation,
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