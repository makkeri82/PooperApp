package com.example.pooperapp

import com.google.android.gms.maps.model.LatLng

// TODO: Create item class for poop marker
class PoopData() {

    fun GetPoopData(): List<PoopMarkerData> {
        return listOf(
            PoopMarkerData(
                location = LatLng(65.1763, 25.3532),
                description = "smelly"
            ),
            PoopMarkerData(
                location = LatLng(65.0121, 25.4651),
                description = "Good"
            ),
            PoopMarkerData(
                location = LatLng(65.1286, 25.3567),
                description = "not good"
            ),
            PoopMarkerData(
                location = LatLng(65.1290, 25.3580),
                description = "bad"
            ),
            PoopMarkerData(
                location = LatLng(65.1299, 25.3590),
                description = "water"
            ),
        )
    }
}

data class PoopMarkerData(
    var location: LatLng,
    var description: String? = null
)