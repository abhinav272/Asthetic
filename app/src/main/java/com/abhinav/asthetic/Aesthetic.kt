package com.abhinav.asthetic

import android.app.Application

/**
 * Created by abhinav.sharma on 28/12/17.
 */
class Aesthetic : Application() {

    init {
        instance = this
    }

    companion object {
        lateinit var instance: Aesthetic
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}