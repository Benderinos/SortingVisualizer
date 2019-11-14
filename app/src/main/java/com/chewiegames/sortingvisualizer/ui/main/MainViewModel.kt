package com.chewiegames.sortingvisualizer.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlin.math.floor

private const val TAG = "MainViewModel"
class MainViewModel : ViewModel() {

    var array = arrayListOf<Int>()

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

    fun mergeSort(array: ArrayList<Int>): ArrayList<Int> {
        val kotlinSortedArray = ArrayList<Int>(array.slice(0 until array.size).sorted())
        val mergeSortedArray = doMergeSort(array)
        Log.i(TAG, "" + arrayAreEquals(kotlinSortedArray, mergeSortedArray))
        return doMergeSort(array)
    }

    private fun arrayAreEquals(arrayOne: ArrayList<Int>, arrayTwo: ArrayList<Int>) : Boolean{
        if(arrayOne.size != arrayTwo.size) return false
        for(i in arrayOne.indices){
            if(arrayOne[i] != arrayTwo[i]){
                return false
            }
        }
        return true
    }
}

