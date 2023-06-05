package com.example.thmanyahpodcast.core.application

import android.app.Application
import coil.Coil
import coil.ImageLoader
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ThmanyahApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val imageLoader = ImageLoader.Builder(this)
            .respectCacheHeaders(false)
            .build()
        Coil.setImageLoader(imageLoader)
    }
}