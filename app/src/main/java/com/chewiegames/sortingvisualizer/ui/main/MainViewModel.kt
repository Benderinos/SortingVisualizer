package com.chewiegames.sortingvisualizer.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlin.math.floor

class MainViewModel : ViewModel() {

    private var array = IntArray(NUMBER_OF_ARRAY_BARS)

    init {
        resetArray()
        mergeSort(this.array, 0, this.array.size-1)
    }

    fun resetArray() : IntArray {
        val array = IntArray(NUMBER_OF_ARRAY_BARS)
        for (i in 0 until NUMBER_OF_ARRAY_BARS) {
            array[i] = randomNumberFromIntervals(5, 100)
        }
        this.array = array
        return array
    }

    private fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()


    fun doMergeSort(array: IntArray, startIndex: Int, middleIndex: Int, endIndex: Int) {

        val sizeLeft = middleIndex - startIndex + 1
        val sizeRight = endIndex - middleIndex
        val leftArray = array.slice(0..sizeLeft)
        val rightArray = array.slice(middleIndex..endIndex)
        var i = 0
        var j = 0
        var k = 1
        while (i < sizeLeft && j < sizeRight) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i]
                i++
            } else {
                array[k] = rightArray[j]
            }
            k++
        }

        while (i < sizeLeft) {
            array[k] = leftArray[i]
            i++
            k++
        }
        while (j < sizeRight){
            array[k] = rightArray[j]
            j++
            k++
        }
    }

    fun mergeSort(array: IntArray, startIndex: Int, endIndex: Int){
        if( startIndex < endIndex){
            val middleIndex = (startIndex+endIndex) / 2
            mergeSort(array, startIndex, middleIndex)
            mergeSort(array, middleIndex+1, endIndex)
            doMergeSort(array, startIndex, middleIndex, endIndex)
        }
    }
}