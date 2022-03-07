package com.ammase.androidkotlinchooselanguageexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.ammase.androidkotlinchooselanguageexample.databinding.ActivityMainBinding
import com.ammase.androidkotlinchooselanguageexample.utils.GlobalVariable
import com.ammase.androidkotlinchooselanguageexample.utils.LanguageHelper

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private fun enSelectedView() {
        //binding.llEnglish.setBackgroundResource(R.drawable.ic_baseline_check_circle_24)
        binding.ivEnChecked.visibility = View.VISIBLE
        //binding.llIndonesia.setBackgroundResource(R.drawable.ic_baseline_check_circle_outline_24)
        binding.ivIdChecked.visibility = View.GONE
    }

    private fun idSelectedView() {
        //binding.llEnglish.setBackgroundResource(R.drawable.ic_baseline_check_circle_outline_24)
        binding.ivEnChecked.visibility = View.GONE
        // binding.llIndonesia.setBackgroundResource(R.drawable.ic_baseline_check_circle_24)
        binding.ivIdChecked.visibility = View.VISIBLE
    }

    override fun setup(savedInstanceState: Bundle?) {
        binding.llIndonesia.setOnClickListener {
            LanguageHelper.setLocale(this, GlobalVariable.ID_LANGUAGE)
            idSelectedView()
            //   finish()
            overridePendingTransition(0, 0)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        binding.llEnglish.setOnClickListener {
            LanguageHelper.setLocale(this, GlobalVariable.EN_LANGUAGE)
            enSelectedView()
            // finish()
            overridePendingTransition(0, 0)
            startActivity(intent)
            overridePendingTransition(0, 0)
        }

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
        }
    }

}