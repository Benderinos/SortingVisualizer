package com.chewiegames.sortingvisualizer.algorithms

import com.chewiegames.sortingvisualizer.Column
import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 50 //259 is for looking good
const val SIZE_COLUMN = 380 //259 is for looking good
const val ANIMATION_SPEED = 3L

var animations = hashMapOf<Int, Int>()

fun getMergeSortAnimations(list: List<Column>) : Map<Int, Int> {
    animations = hashMapOf()
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
    var animationsIndex = 0
    var middle = middleIndex+1
    var leftIndex = 0
    var rightIndex = 0
    while (leftIndex < left.count() && rightIndex < right.count()){
        animations.put(leftIndex, middle)
        animations.put(leftIndex, middle)
        if(left[leftIndex].value <= right[rightIndex].value){
            animations.put(animationsIndex, left[leftIndex].value)
            result.add(left[leftIndex])
            leftIndex++
            animationsIndex++
        }else{
            animations.put(animationsIndex, right[rightIndex].value)
            result.add(right[rightIndex])
            rightIndex++
            animationsIndex++
            middle++
        }
    }

    while (leftIndex < left.size){
        animations.put(leftIndex, leftIndex)
        animations.put(leftIndex, leftIndex)
        animations.put(animationsIndex, left[leftIndex].value)
        result.add(left[leftIndex])
        leftIndex++
        animationsIndex++
    }

    while(rightIndex < right.size){
        animations.put(middle, middle)
        animations.put(middle, middle)
        animations.put(animationsIndex, right[rightIndex].value)
        result.add(right[rightIndex])
        rightIndex++
        animationsIndex++
        middle++
    }
    return result
}
