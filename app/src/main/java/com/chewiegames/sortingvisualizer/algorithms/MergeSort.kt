package com.chewiegames.sortingvisualizer.algorithms

import com.chewiegames.sortingvisualizer.Column
import kotlin.math.floor

fun  getMergeSortAnimationsNew(array: ArrayList<Column>) : List<Any> {
    val animations = arrayListOf<Int>();
    if (array.size <= 1) return array;
    mergeSortHelper(array, 0, array.size - 1, array, animations);
    return animations;
}

fun mergeSortHelper(
mainArray: ArrayList<Column>,
startIdx: Int,
endIdx: Int,
auxiliaryArray: ArrayList<Column>,
animations: ArrayList<Int>
) {
    if (startIdx == endIdx) return;
    val middleIdx = floor((startIdx + endIdx).toFloat() / 2).toInt()
    mergeSortHelper(auxiliaryArray, startIdx, middleIdx, mainArray, animations);
    mergeSortHelper(auxiliaryArray, middleIdx + 1, endIdx, mainArray, animations);
    doMerge(mainArray, startIdx, middleIdx, endIdx, auxiliaryArray, animations);
}

fun doMerge(
mainArray: ArrayList<Column>,
startIdx: Int,
middleIdx: Int,
endIdx: Int,
auxiliaryArray: List<Column>,
animations: ArrayList<Int>
) {
    var k = startIdx
    var i = startIdx
    var j = middleIdx + 1
    while (i <= middleIdx && j <= endIdx) {
        // These are the values that we're comparing; we push them once
        // to change their color.
        animations.add(i, j);
        // These are the values that we're comparing; we push them a second
        // time to revert their color.
        animations.add(i, j);
        if (auxiliaryArray[i].value <= auxiliaryArray[j].value) {
            // We overwrite the value at index k in the original array with the
            // value at index i in the auxiliary array.
            animations.add(k, auxiliaryArray[i].value);
            mainArray[k++] = auxiliaryArray[i++];
        } else {
            // We overwrite the value at index k in the original array with the
            // value at index j in the auxiliary array.
            animations.add(k, auxiliaryArray[j].value);
            mainArray[k++] = auxiliaryArray[j++];
        }
    }
    while (i <= middleIdx) {
        // These are the values that we're comparing; we push them once
        // to change their color.
        animations.add(i, i);
        // These are the values that we're comparing; we push them a second
        // time to revert their color.
        animations.add(i, i);
        // We overwrite the value at index k in the original array with the
        // value at index i in the auxiliary array.
        animations.add(k, auxiliaryArray[i].value);
        mainArray[k++] = auxiliaryArray[i++];
    }
    while (j <= endIdx) {
        // These are the values that we're comparing; we push them once
        // to change their color.
        animations.add(j, j);
        // These are the values that we're comparing; we push them a second
        // time to revert their color.
        animations.add(j, j);
        // We overwrite the value at index k in the original array with the
        // value at index j in the auxiliary array.
        animations.add(k, auxiliaryArray[j].value);
        mainArray[k++] = auxiliaryArray[j++];
    }
}
