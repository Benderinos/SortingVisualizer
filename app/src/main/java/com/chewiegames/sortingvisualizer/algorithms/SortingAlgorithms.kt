package com.chewiegames.sortingvisualizer.algorithms

import android.util.Log
import com.chewiegames.sortingvisualizer.Column
import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 50 //260 looking good
const val SIZE_COLUMN = 380 //380 looking good
const val ANIMATION_SPEED = 1L

var animations = arrayListOf<Int>()

private const val TAG = "SortingAlgorithms"
fun getMergeSortAnimations(list: List<Column>) : List<Int>{
    animations = arrayListOf()
    doMergeSort(list)
    return animations
}

fun doMergeSort(list: List<Column>): List<Column> {
    if(list.size <= 1) return list
    val middleIndex = floor((list.size / 2.0)).toInt()
    val left = list.subList(0, middleIndex)
    val right = list.subList(middleIndex, list.size)
    return merge(doMergeSort(left), doMergeSort(right), middleIndex)
}

fun merge(left: List<Column>, right: List<Column>, middle: Int) : List<Column>{
    val result = arrayListOf<Column>()
    var leftIndex = 0
    var rightIndex = 0
    var middleIndex = middle
    while (leftIndex < left.count() && rightIndex < right.count()){
        animations.add(middleIndex)
        animations.add(middleIndex)
        if(left[leftIndex].value <= right[rightIndex].value){
            animations.add(left[leftIndex].value)
            result.add(left[leftIndex])
            leftIndex++
        }else{
            animations.add(right[rightIndex].value)
            result.add(right[rightIndex])
            rightIndex++
            middleIndex++
        }
    }

    while (leftIndex < left.size){
        animations.add(leftIndex)
        animations.add(leftIndex)
        animations.add(left[leftIndex].value)
        result.add(left[leftIndex])
        leftIndex++
    }

    while(rightIndex < right.size){
        animations.add(middleIndex)
        animations.add(middleIndex)
        animations.add(right[rightIndex].value)
        result.add(right[rightIndex])
        rightIndex++
        middleIndex++
    }
    return result
}
