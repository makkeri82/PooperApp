package com.example.pooperapp

import android.app.Application
import com.example.pooperapp.di.PooperModule
import com.example.pooperapp.di.PooperModuleImpl

// TODO: add repositorys, PoopDb and LocationRepo
class PooperApp: Application() {

    companion object {
        lateinit var pooperModule: PooperModule
    }

    override fun onCreate() {
        super.onCreate()
        pooperModule = PooperModuleImpl(this)
    }
}