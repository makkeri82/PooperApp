package com.example.pooperapp.repository

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.pooperapp.data.PoopData
import com.example.pooperapp.data.PoopMarkerData
import kotlin.math.log

class PoopRepositoryImpl (
    poopData: PoopData
) : PoopRepository {

    private val _poops = poopData.getPoopData().toMutableStateList()
    val poops: SnapshotStateList<PoopMarkerData> get() = _poops

    override fun getPoops(): List<PoopMarkerData> {
        return poops
    }

    override fun addPoop(poop: PoopMarkerData) {
        _poops.add(poop)
    }

    override fun removePoop(poop: PoopMarkerData) {
        _poops.remove(poop)
    }
}