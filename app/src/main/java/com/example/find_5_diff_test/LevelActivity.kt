package com.example.find_5_diff_test

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.find_5_diff_test.databinding.ActivityLevelsSelectionBinding


class LevelActivity: AppCompatActivity() {
    var differencesCnt = 5
    var differenvesFnd = 0

    var level_num = 1

    var ImageList1 = mutableListOf<ImageView>()
    var ImageList2 = mutableListOf<ImageView>()

    var level_res_manager = LevelResources()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        level_num = intent.getIntExtra("LevelNum", 1)
        setContentView(level_res_manager.LIST_of_level_xml[level_num]!!)





        differencesCnt = DataSaveManager(this).getDifferencesCountInLevel(level_num)
        differenvesFnd = DataSaveManager(this).getDifferencesFoundInLevel(level_num)

        for(i in level_res_manager.LIST_of_dif1_images[level_num]!!)
        {
            ImageList1.add(findViewById(i))
        }
        for(i in level_res_manager.LIST_of_dif2_images[level_num]!!)
        {
            ImageList2.add(findViewById(i))
        }

        var dif_numbers : MutableList<Int> = DataSaveManager(this).getDifferencesFoundInLevel_LIST(level_num)

        for(i in dif_numbers)
        {
            ImageList1[i].setAlpha(1.0f)
            ImageList2[i].setAlpha(1.0f)
        }


    }

    fun onClickDifCheck(p0: View) {

        for (i in 0..(differencesCnt - 1)) {
            if (ImageList1[i].id == p0.id || ImageList2[i].id == p0.id) {
                if (ImageList1[i].alpha == 0.0f && ImageList2[i].alpha == 0.0f) {
                    differenvesFnd++
                    DataSaveManager(this).setDifferencesFoundInLevel(level_num, i)
                    if (differenvesFnd == differencesCnt) {
                        DataSaveManager(this).setIsLevelSolved(level_num, true)
                        supportFragmentManager.beginTransaction()
                            .replace(level_res_manager.LIST_of_frag_holders[level_num]!!, WinScreenFragment.newInstance(context = this)).commit()
                    }


                    ImageList1[i].setAlpha(1.0f)
                    ImageList2[i].setAlpha(1.0f)

                    Log.i("BILLY!!!", p0.id.toString())
                    break
                }
            }
        }
    }
}