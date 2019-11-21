package com.chewiegames.sortingvisualizer.algorithms

import com.chewiegames.sortingvisualizer.model.Column
import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 250 //260 looking good
const val SIZE_COLUMN = 380 //380 looking good
const val ANIMATION_SPEED = 3L

var generalMiddle=0
private const val TAG = "SortingAlgorithms"
fun getMergeSortAnimations(list: List<Column>) : ArrayList<Array<Int>>{
    val animations = arrayListOf<Array<Int>>()
    generalMiddle=floor((list.size / 2.0)).toInt()
    doMergeSort(list, animations)
    return animations
}

fun doMergeSort(list: List<Column>, animations: ArrayList<Array<Int>>): List<Column> {
    if(list.size <= 1) return list
    val middleIndex = floor((list.size / 2.0)).toInt()
    val left = list.subList(0, middleIndex)
    val right = list.subList(middleIndex, list.size)
    return merge(doMergeSort(left, animations), doMergeSort(right, animations), middleIndex, animations)
}

fun merge(left: List<Column>, right: List<Column>, middle: Int, animations: ArrayList<Array<Int>>) : List<Column>{
    val result = arrayListOf<Column>()
    var k=0
    var leftIndex = 0
    var rightIndex = 0
    var middleIndex = middle
    while (leftIndex < left.count() && rightIndex < right.count()){
        animations.add(arrayOf(leftIndex, middleIndex))
        animations.add(arrayOf(leftIndex, middleIndex))
        if(left[leftIndex].value <= right[rightIndex].value){
            animations.add(arrayOf(k++, left[leftIndex].value))
            result.add(left[leftIndex++])
        } else {
            animations.add(arrayOf(k++, right[rightIndex].value))
            result.add(right[rightIndex++])
            generalMiddle++
            middleIndex++
        }
    }

    while (leftIndex < left.size) {
        animations.add(arrayOf(leftIndex, leftIndex))
        animations.add(arrayOf(leftIndex, leftIndex))
        animations.add(arrayOf(k++, left[leftIndex].value))
        result.add(left[leftIndex++])
    }

    while (rightIndex < right.size) {
        animations.add(arrayOf(middleIndex, middleIndex))
        animations.add(arrayOf(middleIndex, middleIndex))
        animations.add(arrayOf(k++, right[rightIndex].value))
        result.add(right[rightIndex++])
        generalMiddle++
        middleIndex++
    }
    return result
}
