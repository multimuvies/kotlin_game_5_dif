package com.example.find_5_diff_test

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.transition.Visibility
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.find_5_diff_test.databinding.FragmentWinScreenBinding

class WinScreenFragment(private val context : Context) : Fragment() {

    lateinit var binding : FragmentWinScreenBinding

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWinScreenBinding.inflate(inflater)
        var ThemeColor = DataSaveManager(context).getThemeColor()

        binding.toLvlBtn.setBackgroundTintList(context.getResources().getColorStateList(ThemeColor))
        binding.toLevelSelectBtn.setBackgroundTintList(context.getResources().getColorStateList(ThemeColor))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toLvlBtn.setOnClickListener{

            view.visibility = View.INVISIBLE
        }
        binding.toLevelSelectBtn.setOnClickListener{
            getActivity()?.onBackPressed()
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(context: Context) = WinScreenFragment(context)
    }
}