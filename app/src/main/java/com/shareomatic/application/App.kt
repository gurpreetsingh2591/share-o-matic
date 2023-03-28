package com.shareomatic.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.shareomatic.utils.SharedPrefrencesUtils

class App : Application() {
    private var currentApplication: App? = null

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
        SharedPrefrencesUtils.init(applicationContext)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        //  val appComponent = DaggerApplicationComponent.create()
    }
    fun getInstance(): App? {

        return currentApplication
    }


}