package com.ammase.androidkotlinchooselanguageexample

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import com.ammase.androidkotlinchooselanguageexample.utils.LanguageHelper

class MyApplication: Application() {



    override fun onCreate() {
        super.onCreate()
       // PreferenceManager.initx(this)
//        LanguageHelper.onAttach(this)
        setAppContext(this)
        instance = this
    }


    companion object {
        private lateinit var mAppContext: Context

        @get:Synchronized
        lateinit var instance: MyApplication

        private fun setAppContext(ctx: Context) {
            mAppContext = ctx
        }

        fun getAppContext(): Context {
            return mAppContext
        }

        const val FETCH_NAMESPACE = "KLIPZ_DOWNLOADER"
    }






//    fun logout() {
//        val tempLanguage = PreferenceManager.instance.getString(LanguageHelper.SELECTED_LANGUAGE, GlobalVariable.EN_LANGUAGE)
//        PreferenceManager.instance.sharedPref.edit().clear().apply()
//        PreferenceManager.instance.putString(LanguageHelper.SELECTED_LANGUAGE, tempLanguage.toString())
//        startActivity(
//            Intent(
//                getAppContext(),
//                LoginActivity::class.java
//            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//        )
//    }


}