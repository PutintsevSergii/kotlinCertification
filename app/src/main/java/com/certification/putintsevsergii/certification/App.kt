package com.certification.putintsevsergii.certification

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.certification.putintsevsergii.certification.database.Database

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Database.getInstance(context = applicationContext)
    }
}