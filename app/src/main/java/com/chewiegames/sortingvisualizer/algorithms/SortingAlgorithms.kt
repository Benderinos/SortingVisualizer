package com.chewiegames.sortingvisualizer.algorithms

import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 259

fun doMergeSort(list: List<Int>): List<Int> {
    if(list.size <= 1) return list
    val middleIndex = floor((list.size / 2.0)).toInt()
    val left = list.subList(0, middleIndex)
    val right = list.subList(middleIndex, list.size)
    return merge(doMergeSort(left), doMergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>) : List<Int>{
    val result = arrayListOf<Int>()
    var leftIndex = 0
    var rightIndex = 0
    while (leftIndex < left.count() && rightIndex < right.count()){
        if(left[leftIndex] <= right[rightIndex]){
            result.add(left[leftIndex])
            leftIndex++
        }else{
            result.add(right[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < left.size){
        result.add(left[leftIndex])
        leftIndex++
    }

    while(rightIndex < right.size){
        result.add(right[rightIndex])
        rightIndex++
    }
    return result
}
