package com.example.pooperapp.viewmodels

import com.google.android.gms.maps.model.LatLng

sealed class LocationUiState {
    object Loading : LocationUiState()
    data class Success(val location: LatLng) : LocationUiState()
    data class Error(val message: String) : LocationUiState()
}
