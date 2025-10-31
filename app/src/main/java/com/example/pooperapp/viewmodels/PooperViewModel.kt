package com.example.pooperapp.viewmodels

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pooperapp.data.PoopMarkerData
import com.example.pooperapp.di.PooperModule
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PooperViewModel(
    private val pooperModule: PooperModule
) : ViewModel() {

    val poops: SnapshotStateList<PoopMarkerData>
        get() = pooperModule.pooperRepo.getPoops() as SnapshotStateList<PoopMarkerData>

    private val _locationUiState = MutableStateFlow<LocationUiState>(LocationUiState.Loading)
    val locationUiState: StateFlow<LocationUiState> = _locationUiState.asStateFlow()

    init {
        getCurrentLocation()
    }

    fun addPoop() {
        val newId = (poops.maxOfOrNull { it.id } ?: 0) + 1

        viewModelScope.launch {
            val loc = pooperModule.locationRepo.getCurrentLocation()
            loc?.let {
                pooperModule.pooperRepo.addPoop(PoopMarkerData(
                    id = newId,
                    location = it,
                    description = ""
                    )
                )
            }
        }
    }

    fun getCurrentLocation() {
        viewModelScope.launch {
            // Thread.sleep(5000)
            _locationUiState.value = LocationUiState.Loading
            val location = pooperModule.locationRepo.getCurrentLocation()
            if (location != null) {
                _locationUiState.value = LocationUiState.Success(location)
            } else {
                _locationUiState.value = LocationUiState.Error("Failed to get current location.")
            }
        }
    }
}
