package com.chewiegames.sortingvisualizer.algorithms

import com.chewiegames.sortingvisualizer.Column
import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 50 //260 looking good
const val SIZE_COLUMN = 380 //380 looking good
const val ANIMATION_SPEED = 3L

var animations = arrayListOf<Int>()
var middleIndex = 0

fun getMergeSortAnimations(list: List<Column>) : List<Int>{
    animations = arrayListOf()
    middleIndex = floor((list.size / 2.0)).toInt()
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

fun merge(left: List<Column>, right: List<Column>, middleIndex: Int) : List<Column>{
    val result = arrayListOf<Column>()
    var leftIndex = 0
    var rightIndex = 0
    var animationsIndex = leftIndex
    var middleIndex = middleIndex+1
    while (leftIndex < left.count() && rightIndex < right.count()){
        animations.add(leftIndex, middleIndex)
        animations.add(leftIndex, middleIndex)
        if(left[leftIndex].value <= right[rightIndex].value){
            animations.add(animationsIndex, left[leftIndex].value)
            result.add(left[leftIndex])
            leftIndex++
        }else{
            animations.add(animationsIndex, right[rightIndex].value)
            result.add(right[rightIndex])
            rightIndex++
            middleIndex++
        }
        animationsIndex++
    }

    while (leftIndex < left.size){
        animations.add(leftIndex, leftIndex)
        animations.add(leftIndex, leftIndex)
        animations.add(animationsIndex, left[leftIndex].value)
        result.add(left[leftIndex])
        leftIndex++
        animationsIndex++
    }

    while(rightIndex < right.size){
        animations.add(middleIndex, middleIndex)
        animations.add(middleIndex, middleIndex)
        animations.add(animationsIndex, right[rightIndex].value)
        result.add(right[rightIndex])
        rightIndex++
        animationsIndex++
        middleIndex++
    }
    return result
}
