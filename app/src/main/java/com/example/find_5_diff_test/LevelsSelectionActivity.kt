package com.example.find_5_diff_test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.find_5_diff_test.databinding.ActivityLevelsSelectionBinding

class LevelsSelectionActivity : AppCompatActivity() {
    val adapter = LevelCardAdapter(this)
    lateinit var binding : ActivityLevelsSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLevelsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    override fun onResume() {

        super.onResume()
        binding = ActivityLevelsSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }
    private fun init() {
        binding.apply {
            adapter.clearAll()
            rcView.layoutManager = GridLayoutManager(this@LevelsSelectionActivity, 3)
            rcView.adapter = adapter
            var level_res_manager = LevelResources()
            var levels_number = level_res_manager.levels_number
            for (i in 1..levels_number)
            {


                var isSolved = DataSaveManager(this@LevelsSelectionActivity).getIsLevelSolved(i)
                val level_card = LevelCard(level_res_manager.LIST_imageId[i]!!, "Level $i", isSolved)
               adapter.addCard(level_card)
            }
        }
    }

    /*
    fun onClickLevel1(p0 : View){
        if(p0.id == R.id.lvl1_btn) {
            val intent = Intent(this@, LevelActivity::class.java)
            intent.putExtra("LevelNum", 1)
            startActivity(intent)
        }
    }

     */
}