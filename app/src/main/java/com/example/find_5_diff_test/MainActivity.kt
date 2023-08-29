package com.example.find_5_diff_test

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        //DataSaveManager(this).clearAllData()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //DataSaveManager(this).setThemeColor(R.color.theme_red)
        var ThemeColor = DataSaveManager(this).getThemeColor()

        findViewById<Button>(R.id.level_select_btn).setBackgroundTintList(this.getResources().getColorStateList(ThemeColor))
        findViewById<Button>(R.id.settings_btn).setBackgroundTintList(this.getResources().getColorStateList(ThemeColor))
        findViewById<Button>(R.id.about_btn).setBackgroundTintList(this.getResources().getColorStateList(ThemeColor))
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onResume() {
        super.onResume()
        var ThemeColor = DataSaveManager(this).getThemeColor()

        findViewById<Button>(R.id.level_select_btn).setBackgroundTintList(this.getResources().getColorStateList(ThemeColor))
        findViewById<Button>(R.id.settings_btn).setBackgroundTintList(this.getResources().getColorStateList(ThemeColor))
        findViewById<Button>(R.id.about_btn).setBackgroundTintList(this.getResources().getColorStateList(ThemeColor))

    }
    fun onClickGoAbout(p0 : View) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoSettings(p0 : View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    fun onClickGoLevelSelect(p0 : View) {
        val intent = Intent(this, LevelsSelectionActivity::class.java)
        startActivity(intent)
    }
}