package com.example.pooperapp.repository

interface LocationRepository {
    suspend fun getLastLocation()
    suspend fun getCurrentLocation()
}