package com.example.pooperapp

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class PooperViewModel : ViewModel() {

    private val _poops = PoopData().getPoopData().toMutableStateList()

    val poops: List<PoopMarkerData> get() = _poops

//    val poops: List<PoopMarkerData>
//        get() = PoopData().getPoopData()

    fun addNewPoop(item: PoopMarkerData) {
        //_poops.add(item)
        Log.d("PooperApp", "NEW POOP! location: " + item.location.toString())
        _poops.add((item))
    }

    fun removePoop(item: PoopMarkerData) {
        _poops.remove(item)
    }
}