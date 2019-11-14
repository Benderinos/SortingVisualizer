package com.chewiegames.sortingvisualizer.algorithms

import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 259

fun doMergeSort(array: ArrayList<Int>): ArrayList<Int> {
    if(array.size == 1) return array
    val middleIndex = floor(array.size.toDouble() / 2).toInt()
    var tempArrayList = ArrayList<Int>(array.slice(0.. middleIndex-1))
    val firstHalf = ArrayList<Int>(doMergeSort(tempArrayList))
    tempArrayList = ArrayList(array.slice(middleIndex.. array.size-1))
    val secondHalf = ArrayList<Int>(doMergeSort(tempArrayList))
    val sortedArray = arrayListOf<Int>()
    var i = 0
    var j = 0
    while (i < firstHalf.size && j < secondHalf.size) {
        if (firstHalf[i] < secondHalf[j]) {
            sortedArray.add(secondHalf[i])
            i++
        } else {
            sortedArray.add(secondHalf[j])
            j++
        }
    }
    while (i < firstHalf.size) {
        sortedArray.add(firstHalf[i])
        i++
    }
    while (j < secondHalf.size) {
        sortedArray.add(secondHalf[j])
        j++
    }
    return sortedArray
}
