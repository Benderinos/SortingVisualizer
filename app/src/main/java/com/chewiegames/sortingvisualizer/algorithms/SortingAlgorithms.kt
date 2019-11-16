package com.chewiegames.sortingvisualizer.algorithms

import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 260 //259 is for looking good
const val ANIMATION_SPEED = 3L

var animations = hashMapOf<Int, Int>()

fun getMergeSortAnimations(list: List<Int>) : Map<Int, Int> {
    animations = hashMapOf()
    doMergeSort(list)
    return animations
}

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

        animations[leftIndex] = rightIndex
        animations[leftIndex] = rightIndex
        if(left[leftIndex] <= right[rightIndex]){
            animations[leftIndex] = left[leftIndex]
            result.add(left[leftIndex])
            leftIndex++
        }else{
            animations[rightIndex] = right[rightIndex]
            result.add(right[rightIndex])
            rightIndex++
        }
    }

    while (leftIndex < left.size){
        animations[leftIndex] = leftIndex
        animations[leftIndex] = leftIndex
        result.add(left[leftIndex])
        leftIndex++
    }

    while(rightIndex < right.size){
        animations[rightIndex] = rightIndex
        animations[rightIndex] = rightIndex
        result.add(right[rightIndex])
        rightIndex++
    }
    return result
}
