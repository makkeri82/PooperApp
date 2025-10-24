package com.example.pooperapp.repository

import com.example.pooperapp.data.PoopData
import com.example.pooperapp.data.PoopMarkerData

interface PoopRepository {
    fun getPoops(): List<PoopMarkerData>
    fun addPoop(poop: PoopMarkerData)
    fun removePoop(poop: PoopMarkerData)
}