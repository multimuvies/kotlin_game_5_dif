package com.example.find_5_diff_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    fun onClick(view : View)
    {
        if(view.id == R.id.red_col_btn)
        {
            DataSaveManager(this).setThemeColor(R.color.theme_red)
        }
        if(view.id == R.id.blue_col_btn)
        {
            DataSaveManager(this).setThemeColor(R.color.theme_blue)
        }
        if(view.id == R.id.violet_col_btn)
        {
            DataSaveManager(this).setThemeColor(R.color.theme_violet)
        }
        if(view.id == R.id.yellow_col_btn)
        {
            DataSaveManager(this).setThemeColor(R.color.theme_yellow)
        }
        if(view.id == R.id.green_col_btn)
        {
            DataSaveManager(this).setThemeColor(R.color.theme_green)
        }
        if(view.id == R.id.dark_col_btn)
        {
            DataSaveManager(this).setThemeColor(R.color.theme_dark)
        }
    }
}