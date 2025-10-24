package com.example.pooperapp.repository

import android.annotation.SuppressLint
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.model.LatLng
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationRepositoryImpl(
    private val fusedClient: FusedLocationProviderClient
) : LocationRepository {

    @SuppressLint("MissingPermission")
    override suspend fun getCurrentLocation(): LatLng? = suspendCoroutine { cont ->
        fusedClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null)
                    cont.resume(LatLng(location.latitude, location.longitude))
                else
                    cont.resume(null)
            }
            .addOnFailureListener {
                cont.resume(null)
            }
    }

    override suspend fun getLastLocation() {
        TODO("Not yet implemented")
    }

}