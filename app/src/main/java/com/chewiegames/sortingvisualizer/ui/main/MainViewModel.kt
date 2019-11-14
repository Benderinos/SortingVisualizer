package com.chewiegames.sortingvisualizer.ui.main

import androidx.lifecycle.ViewModel
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlin.math.floor

class MainViewModel : ViewModel() {

    var array = IntArray(NUMBER_OF_ARRAY_BARS)

    init {
        resetArray()
    }

    fun resetArray() : IntArray {
        val array = IntArray(NUMBER_OF_ARRAY_BARS)
        for (i in 0 until NUMBER_OF_ARRAY_BARS) {
            array[i] = randomNumberFromIntervals(5, 350)
        }
        this.array = array
        return array
    }

    private fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()

    fun mergeSort(array: IntArray) : IntArray{
        return array
    }
}

