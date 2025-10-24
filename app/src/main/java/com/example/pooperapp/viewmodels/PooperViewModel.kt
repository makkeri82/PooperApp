package com.example.pooperapp.viewmodels

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.pooperapp.data.PoopMarkerData
import com.example.pooperapp.di.PooperModule
import com.google.android.gms.maps.model.LatLng

class PooperViewModel(
    private val pooperModule: PooperModule
) : ViewModel() {

    val poops: SnapshotStateList<PoopMarkerData>
        get() = pooperModule.pooperRepo.getPoops() as SnapshotStateList<PoopMarkerData>

    fun addPoop(location: LatLng, description: String?) {
        val newId = (poops.maxOfOrNull { it.id } ?: 0) + 1
        pooperModule.pooperRepo.addPoop(PoopMarkerData(
            id = newId,
            location = location,
            description = description
        ))
    }
}