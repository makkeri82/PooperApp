package com.example.pooperapp.viewmodels

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pooperapp.data.PoopMarkerData
import com.example.pooperapp.di.PooperModule
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

class PooperViewModel(
    private val pooperModule: PooperModule
) : ViewModel() {

    val poops: SnapshotStateList<PoopMarkerData>
        get() = pooperModule.pooperRepo.getPoops() as SnapshotStateList<PoopMarkerData>

    fun addPoop(/*location: LatLng, description: String?*/) {
        val newId = (poops.maxOfOrNull { it.id } ?: 0) + 1

//        println("addPoop: ID: " + newId)
//        println("location, LAT: " + location.latitude + ", LONG: " + location.longitude)
//        println("addPoop: description: " + description)

        viewModelScope.launch {
            val loc = pooperModule.locationRepo.getCurrentLocation()

            // println("loc, LAT: " + loc?.latitude + ", LONG: " + loc?.longitude)

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

    fun getCurrentLocation(): LatLng {

        // TODO: Default location is home location, atm coors are at Oulu
        var returnValue: LatLng = LatLng(65.0121, 25.4651)

        viewModelScope.launch {
            val location = pooperModule.locationRepo.getCurrentLocation()
            println(buildString {
                append("PooperViewModel::getCurrentLocation(): from pooperModule: ")
                append(location.toString())
            })
            location?.let {
                returnValue = location
            }
        }
        println(buildString {
            append("PooperViewModel::getCurrentLocation(): ")
            append(returnValue.toString())
        })
        return returnValue
    }
}