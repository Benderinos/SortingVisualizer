package com.chewiegames.sortingvisualizer

import com.chewiegames.sortingvisualizer.ui.main.MainViewModel
import org.junit.Assert.assertTrue
import org.junit.Test

class MainViewModelTest {

    @Test
    fun mergeSortTest(){
        val viewModel = MainViewModel()
        val array = viewModel.resetArray()
        val kotlinSortedArray = ArrayList<Int>(array.slice(0 until array.size).sorted())
        val mergeSortedArray = viewModel.mergeSort(array)

        assertTrue(kotlinSortedArray.equals( mergeSortedArray))
    }
}