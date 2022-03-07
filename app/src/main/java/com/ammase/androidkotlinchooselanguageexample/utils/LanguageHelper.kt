package com.ammase.androidkotlinchooselanguageexample.utils

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import com.ammase.androidkotlinchooselanguageexample.PreferenceManager
import java.util.Locale

object LanguageHelper {
    const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"
    fun onAttach(context: Context): Context {
        val lang = PreferenceManager.instance.getString(SELECTED_LANGUAGE, Locale.getDefault().language)
        return setLocale(context, lang)
    }

    fun setLocale(context: Context, language: String?): Context {
        updateLanguagePref(language)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResources(context, language)
        } else updateResourcesLegacy(context, language)
    }

    private fun updateLanguagePref(language: String?) =
        PreferenceManager.instance.putString(SELECTED_LANGUAGE, language ?: "en")

    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResources(context: Context, language: String?): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLegacy(context: Context, language: String?): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
        return context
    }
}
