package com.example.pooperapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PooperScreen(
    modifier: Modifier = Modifier,
    startLocation: LatLng,
    pooperViewModel: PooperViewModel = viewModel()
) {
    var newPoop =
        PoopMarkerData(
            location = LatLng(65.1299, 25.3490),
            description = "Good"
        )


    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Maps(
            modifier = Modifier.fillMaxSize(),
            location = startLocation,
            poopData = pooperViewModel.poops
        )
        PooperButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            onClick = { pooperViewModel.addNewPoop(newPoop) }
        )
    }
}