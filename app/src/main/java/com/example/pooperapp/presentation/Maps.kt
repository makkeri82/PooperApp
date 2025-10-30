@file:OptIn(MapsComposeExperimentalApi::class)

package com.example.pooperapp.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapsComposeExperimentalApi
import com.google.maps.android.compose.clustering.Clustering
import com.google.maps.android.compose.rememberCameraPositionState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.pooperapp.R
import com.example.pooperapp.data.PoopMarkerData
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.android.gms.maps.CameraUpdateFactory

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Maps(
    modifier: Modifier = Modifier,
    startLocation: LatLng,
    poopData: List<PoopMarkerData>,
    permissions: MultiplePermissionsState
) {
    Surface(
        modifier = modifier
    ) {
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(startLocation, 10f)
        }

        val mapProps = MapProperties(
            isMyLocationEnabled = permissions.allPermissionsGranted,
            isTrafficEnabled = false,
            isIndoorEnabled = false
        )

        GoogleMap(
            properties = mapProps,
            cameraPositionState = cameraPositionState
        ) {
            Clustering(
                items = poopData,
                onClusterClick = {
                    cameraPositionState.move(
                        update = CameraUpdateFactory.zoomIn()
                    )
                    false
                },
                clusterItemContent = {ClusterItemContent(it)},
            )
        }
    }
}

//
@Composable
fun ClusterItemContent(data: PoopMarkerData) {
    Image(
        painter = painterResource(R.drawable.poop_img),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
    )
}