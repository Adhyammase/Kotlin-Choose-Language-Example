package com.ammase.androidkotlinchooselanguageexample

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.ammase.androidkotlinchooselanguageexample.utils.LanguageHelper
import java.util.Locale

/**
 * Base Activity
 * @author Nur Rahmat Dwi Riyanto
 * Ref : https://chetan-garg36.medium.com/viewbinding-creating-baseclasses-49de9ab7b221
 */

abstract class BaseActivity<viewBinding : ViewBinding> : AppCompatActivity() {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> viewBinding
    private var mCurrentLocale: Locale? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: viewBinding
        get() = _binding as viewBinding

    abstract fun setup(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup(savedInstanceState)

    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LanguageHelper.onAttach(newBase))
    }

    override fun onStart() {
        super.onStart()
        mCurrentLocale = resources.configuration.locale
    }

    override fun onRestart() {
        super.onRestart()
        val lang = PreferenceManager.instance.getString(LanguageHelper.SELECTED_LANGUAGE, Locale.getDefault().language)
        if (lang!! != mCurrentLocale.toString()) {
            mCurrentLocale = Locale(lang)
            startActivity(intent)
            finish()
            overridePendingTransition(0, 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
