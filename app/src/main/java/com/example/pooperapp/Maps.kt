package com.example.pooperapp

import android.Manifest
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Maps(
    modifier: Modifier = Modifier,
    location: LatLng,
    /*mapProps: MapProperties*/) {
    Surface(
        modifier = modifier
    ) {
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(location, 10f)
        }

        val locationPermission = rememberMultiplePermissionsState(
            permissions = listOf(
                "android.permission.ACCESS_FINE_LOCATION",
                "android.permission.ACCESS_COARSE_LOCATION"
            )
        )

        LaunchedEffect(key1 = locationPermission.permissions) {
            locationPermission.launchMultiplePermissionRequest()
        }

        val mapProps = MapProperties(
            isMyLocationEnabled = locationPermission.allPermissionsGranted,
            isTrafficEnabled = false,
            isIndoorEnabled = false
        )

        GoogleMap(
            properties = mapProps,
            cameraPositionState = cameraPositionState
        ) {

        }
    }
}