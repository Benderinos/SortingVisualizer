package com.chewiegames.sortingvisualizer.algorithms

import kotlin.math.floor

const val NUMBER_OF_ARRAY_BARS = 259

fun mergeSortHelper(minArray: IntArray, startIndex: Int, endIndex: Int, auxArray: IntArray) {
    if (startIndex == endIndex) return
    val middleIndex = floor((startIndex + endIndex).toDouble() / 2).toInt()
    mergeSortHelper(auxArray, startIndex, middleIndex, minArray)
    mergeSortHelper(auxArray, middleIndex + 1, endIndex, minArray)
    doMerge(minArray, startIndex, middleIndex, endIndex, auxArray)
}

private fun mergeSortHelper(
    minArray: IntArray,
    startIndex: Int,
    endIndex: Int,
    auxArray: IntArray,
    animations: IntArray
) {
    if (startIndex == endIndex) return
    val middleIndex = floor((startIndex + endIndex).toDouble() / 2).toInt()
    mergeSortHelper(auxArray, startIndex, middleIndex, minArray, animations)
    mergeSortHelper(auxArray, middleIndex + 1, endIndex, minArray, animations)
    doMerge(minArray, startIndex, middleIndex, endIndex, auxArray)
}

fun doMerge(
    minArray: IntArray,
    startIndex: Int,
    middleIndex: Int,
    endIndex: Int,
    auxArray: IntArray
) {

}
