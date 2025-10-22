package com.example.pooperapp

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

// TODO: Create item class for poop marker
class PoopData() {

    fun getPoopData(): List<PoopMarkerData> {
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
    val name: String = "Howe was the poop?",
    var description: String? = null,
    var drawable: Int = R.drawable.poop_icon
) : ClusterItem {
    override fun getPosition(): LatLng = location
    override fun getTitle(): String? = name
    override fun getSnippet(): String? = description
    override fun getZIndex(): Float? = 1f
}