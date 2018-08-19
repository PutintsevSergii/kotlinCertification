package com.certification.putintsevsergii.certification

import android.app.Application
import com.certification.putintsevsergii.certification.database.Database

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Database.getInstance(context = applicationContext)
    }
}