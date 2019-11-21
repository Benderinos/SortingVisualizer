package com.chewiegames.sortingvisualizer.ui.sorting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent

class SortingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainViewModel.resetArray()
        setContent {
            SortScreen()
        }
    }
}
