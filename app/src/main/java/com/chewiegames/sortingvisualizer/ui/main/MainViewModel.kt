package com.chewiegames.sortingvisualizer.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlin.math.floor

private const val TAG = "MainViewModel"
class MainViewModel : ViewModel() {

    var array = emptyList<Int>()
    var animations = mapOf<Int, Int>()

    init {
        resetArray()
    }

    fun resetArray(): ArrayList<Int> {
        val array = ArrayList<Int>()
        for (i in 0 until NUMBER_OF_ARRAY_BARS) {
            array.add(randomNumberFromIntervals(5, 350))
        }
        this.array = array
        return array
    }

    private fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()

    fun mergeSort(array: List<Int>): List<Int> {
        return doMergeSort(array)
    }

    fun getMergeAnimations(array: List<Int>): Map<Int, Int> {
        return getMergeSortAnimations(array)
    }}

