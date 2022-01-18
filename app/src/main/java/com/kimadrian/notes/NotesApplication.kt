package com.kimadrian.notes

import android.app.Application
import androidx.viewbinding.BuildConfig
import timber.log.Timber

class NotesApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}