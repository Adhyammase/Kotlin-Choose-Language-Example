package com.ammase.androidkotlinchooselanguageexample

import android.app.Application
import android.content.Context

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
       // PreferenceManager.initx(this)
        setAppContext(this)
        instance = this
    }


    companion object {
        private lateinit var mAppContext: Context

        @get:Synchronized
        lateinit var instance: MyApp

        private fun setAppContext(ctx: Context) {
            mAppContext = ctx
        }

        fun getAppContext(): Context {
            return mAppContext
        }

    }

}