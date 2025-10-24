package com.example.pooperapp.di

import android.content.Context
import com.example.pooperapp.PooperApp
import com.example.pooperapp.data.PoopData
import com.example.pooperapp.repository.LocationRepository
import com.example.pooperapp.repository.LocationRepositoryImpl
import com.example.pooperapp.repository.PoopRepository
import com.example.pooperapp.repository.PoopRepositoryImpl
import com.google.android.gms.location.LocationServices

// NOTE: module to collect all dependencys to one place, later on this helps in testing.
interface PooperModule {
    val locationRepo: LocationRepository
    val pooperRepo: PoopRepository
}

class PooperModuleImpl(
    private val appContext: Context
) : PooperModule {

    private val fusedClient = LocationServices.getFusedLocationProviderClient(appContext.applicationContext)

    override val locationRepo: LocationRepository by lazy {
        LocationRepositoryImpl(fusedClient)
    }
    
    override val pooperRepo: PoopRepository by lazy {
        PoopRepositoryImpl(PoopData())
    }
}