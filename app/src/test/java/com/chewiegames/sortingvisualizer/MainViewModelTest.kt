package com.chewiegames.sortingvisualizer

import androidx.ui.graphics.Color
import com.chewiegames.sortingvisualizer.algorithms.NUMBER_OF_ARRAY_BARS
import com.chewiegames.sortingvisualizer.algorithms.SIZE_COLUMN
import com.chewiegames.sortingvisualizer.model.Column
import com.chewiegames.sortingvisualizer.ui.sorting.MainViewModel
import org.junit.Assert.assertTrue
import org.junit.Test

class MainViewModelTest {

    @Test
    fun mergeSortTest() {
        val array = ArrayList<Int>()
        val columns = arrayListOf<Column>()
        for (i in 0 until NUMBER_OF_ARRAY_BARS) {
            val column = Column(i, MainViewModel.randomNumberFromIntervals(5, SIZE_COLUMN), hashMapOf(), Color.Red)
            columns.add(column)
            array.add(column.value)
        }
        val kotlinSortedArray = array.sorted()
        val mergeSortedArray = MainViewModel.mergeSort(columns)
        val newArrayMergeSorted = arrayListOf<Int>()
        for (column in mergeSortedArray){
            newArrayMergeSorted.add(column.value)
        }
        assertTrue(kotlinSortedArray == newArrayMergeSorted)
    }
}