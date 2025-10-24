package com.example.pooperapp.repository

import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.combineTransform
import kotlin.coroutines.suspendCoroutine

interface LocationRepository {

    suspend fun getCurrentLocation(): LatLng?

    suspend fun getLastLocation()
}