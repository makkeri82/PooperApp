package com.example.pooperapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pooperapp.viewmodels.PooperViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(
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