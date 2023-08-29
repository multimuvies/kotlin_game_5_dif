package com.example.find_5_diff_test

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.find_5_diff_test.databinding.LevelCardItemBinding
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.find_5_diff_test.databinding.ActivityLevelsSelectionBinding

import java.util.ArrayList

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(getAdapterPosition(), getItemViewType())
    }
    return this
}

class LevelCardAdapter(var context: Context): RecyclerView.Adapter<LevelCardAdapter.LevelCardHolder>() {
    var levelList = ArrayList<LevelCard>()

    class LevelCardHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = LevelCardItemBinding.bind(item)
        fun bind(card: LevelCard) = with(binding){
            im.setImageResource(card.imageId)
            tvTitle.text = card.title

            if(card.isSolved == true)
                cardView.setCardBackgroundColor(Color.parseColor("#A7D86D"))
            else
                cardView.setCardBackgroundColor(Color.parseColor("#E6E6E6"))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelCardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.level_card_item, parent, false)
        return LevelCardHolder(view).listen { pos, type ->
            val item = levelList.get(pos)
            //TODO do other stuff here
            val intent = Intent(context, LevelActivity::class.java)
            intent.putExtra("LevelNum", pos+1)
            // +1 because of 0-indexation if ViewHolder VS 1-indexation in Levels List
            context.startActivity(intent)
        }
    }

    override fun onBindViewHolder(holder: LevelCardHolder, position: Int) {
        holder.bind(levelList[position])
    }

    override fun getItemCount(): Int {
        return levelList.size
    }

    fun addCard(card: LevelCard){
        levelList.add(card)
        notifyDataSetChanged()
    }

    fun clearAll()
    {
        levelList.clear()
        notifyDataSetChanged()
    }
}