package com.avility.meli

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MeliApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // enabled timber only in debug mode
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}