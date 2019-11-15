package com.chewiegames.sortingvisualizer

import com.chewiegames.sortingvisualizer.ui.main.MainViewModel
import org.junit.Assert.assertTrue
import org.junit.Test

class MainViewModelTest {

    @Test
    fun mergeSortTest(){
        val viewModel = MainViewModel()
        val array = viewModel.resetArray()
        val kotlinSortedArray = array.sorted()
        val mergeSortedArray = viewModel.mergeSort(array)

        assertTrue(kotlinSortedArray == mergeSortedArray)
    }
}