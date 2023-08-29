package com.example.find_5_diff_test

import android.widget.ImageView
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView


class LevelResources() {

    init {

    }

    var levels_number = 5

    var LIST_imageId = listOf(
        null,
        R.drawable.level1,
        R.drawable.level2,
        R.drawable.level3,
        R.drawable.level4,
        R.drawable.level5
    )

    var List_of_dif_cnt = listOf(null, 5, 5, 5, 5, 5)

    var LIST_of_level_xml = listOf(
        null,
        R.layout.level1_layout,
        R.layout.level2_layout,
        R.layout.level3_layout,
        R.layout.level4_layout,
        R.layout.level5_layout
    )

    var LIST_of_dif1_images = listOf(
        null,
        listOf(
            R.id.l1_d1_p1,
            R.id.l1_d2_p1,
            R.id.l1_d3_p1,
            R.id.l1_d4_p1,
            R.id.l1_d5_p1,
        ),
        listOf(
            R.id.l2_d1_p1,
            R.id.l2_d2_p1,
            R.id.l2_d3_p1,
            R.id.l2_d4_p1,
            R.id.l2_d5_p1,
        ),
        listOf(
            R.id.l3_d1_p1,
            R.id.l3_d2_p1,
            R.id.l3_d3_p1,
            R.id.l3_d4_p1,
            R.id.l3_d5_p1,
        ),
        listOf(
            R.id.l4_d1_p1,
            R.id.l4_d2_p1,
            R.id.l4_d3_p1,
            R.id.l4_d4_p1,
            R.id.l4_d5_p1,
        ),
        listOf(
            R.id.l5_d1_p1,
            R.id.l5_d2_p1,
            R.id.l5_d3_p1,
            R.id.l5_d4_p1,
            R.id.l5_d5_p1,
        )
    )

    var LIST_of_dif2_images = listOf(
        null,
        listOf(
            R.id.l1_d1_p2,
            R.id.l1_d2_p2,
            R.id.l1_d3_p2,
            R.id.l1_d4_p2,
            R.id.l1_d5_p2,
        ),
        listOf(
            R.id.l2_d1_p2,
            R.id.l2_d2_p2,
            R.id.l2_d3_p2,
            R.id.l2_d4_p2,
            R.id.l2_d5_p2,
        ),
        listOf(
            R.id.l3_d1_p2,
            R.id.l3_d2_p2,
            R.id.l3_d3_p2,
            R.id.l3_d4_p2,
            R.id.l3_d5_p2,
        ),
        listOf(
            R.id.l4_d1_p2,
            R.id.l4_d2_p2,
            R.id.l4_d3_p2,
            R.id.l4_d4_p2,
            R.id.l4_d5_p2,
        ),
        listOf(
            R.id.l5_d1_p2,
            R.id.l5_d2_p2,
            R.id.l5_d3_p2,
            R.id.l5_d4_p2,
            R.id.l5_d5_p2,
        )
    )

    var LIST_of_frag_holders = listOf(
        null,
        R.id.end_game_holder1,
        R.id.end_game_holder2,
        R.id.end_game_holder3,
        R.id.end_game_holder4,
        R.id.end_game_holder5
    )

}