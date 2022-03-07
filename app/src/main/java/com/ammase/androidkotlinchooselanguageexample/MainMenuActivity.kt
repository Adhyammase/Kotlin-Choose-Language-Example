package com.ammase.androidkotlinchooselanguageexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.ammase.androidkotlinchooselanguageexample.databinding.ActivityMainMenuBinding

class MainMenuActivity : BaseActivity<ActivityMainMenuBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainMenuBinding
        get() = ActivityMainMenuBinding::inflate

    override fun setup(savedInstanceState: Bundle?) {
        return
    }

    override fun statusBarColor(): Int = 0

}