package com.example.find_5_diff_test

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.find_5_diff_test.databinding.ActivityLevelsSelectionBinding


class DataSaveManager(private val context: Context){
    fun getLevelsNumber() : Int
    {
        return LevelResources().levels_number
    }

    fun getDifferencesCountInLevel(level_num : Int) : Int{

        return LevelResources().List_of_dif_cnt[level_num]!!
    }

    fun getDifferencesFoundInLevel(level_num: Int) : Int{

        var shared_table_name = "DATA_TABLE_LVL" + level_num.toString()
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
        var differencesCnt = getDifferencesCountInLevel(level_num)
        var differenvesFnd = 0
        for (i in 0..(differencesCnt - 1)) {
            var if_found = table?.getBoolean(i.toString(), false)!!
            if (if_found) {
                differenvesFnd++
            }
        }
        return differenvesFnd
    }
    fun getDifferencesFoundInLevel_LIST(level_num: Int) : kotlin.collections.MutableList<Int>
    {
        var shared_table_name = "DATA_TABLE_LVL" + level_num.toString()
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)

        var differencesCnt = getDifferencesCountInLevel(level_num)
        var differenvesFndList = mutableListOf<Int>()
        for (i in 0..(differencesCnt - 1)) {
            var if_found = table?.getBoolean(i.toString(), false)!!
            if (if_found) {
                differenvesFndList.add(i)
            }
        }
        return differenvesFndList
    }


    fun setIsLevelSolved(level_num: Int, isSolved : Boolean = true)
    {
        var shared_table_name = "DATA_TABLE_LVL" + level_num.toString()
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
        table.edit().putBoolean("IS_SOLVED", isSolved).apply()

    }
    fun getIsLevelSolved(level_num: Int) : Boolean
    {
        var shared_table_name = "DATA_TABLE_LVL" + level_num.toString()
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
        return table?.getBoolean("IS_SOLVED", false)!!
    }


    fun setDifferencesFoundInLevel(level_num: Int, dif_num : Int, isFound : Boolean = true){
        var shared_table_name = "DATA_TABLE_LVL" + level_num.toString()
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
        table.edit().putBoolean(dif_num.toString(), isFound).apply()
    }

    fun setDifferencesFoundInLevel(level_num: Int, dif_nums : List<Int>){
        for(i in dif_nums)
        {
            setDifferencesFoundInLevel(level_num, i)
        }
    }

    fun clearAllData()
    {
        var level_number = getLevelsNumber()
        for(i in 1..level_number)
        {
            var shared_table_name = "DATA_TABLE_LVL" + i.toString()
            var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
            table.edit().clear().commit()
        }
    }

    fun clearLevelData(level_num: Int)
    {
        var shared_table_name = "DATA_TABLE_LVL" + level_num.toString()
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
        table.edit().clear().commit()
    }

    fun getThemeColor() : Int{
        var shared_table_name = "DATA_TABLE"
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
        return table?.getInt("ThemeColor", R.color.theme_blue)!!
    }

    fun setThemeColor(ThemeColor : Int)
    {
        var shared_table_name = "DATA_TABLE"
        var table = context.getSharedPreferences(shared_table_name, Context.MODE_PRIVATE)
        table.edit().putInt("ThemeColor", ThemeColor).apply()
    }
}