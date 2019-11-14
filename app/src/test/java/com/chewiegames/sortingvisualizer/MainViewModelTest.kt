package com.chewiegames.sortingvisualizer

import com.chewiegames.sortingvisualizer.ui.main.MainViewModel
import org.junit.Test
import java.util.*

class MainViewModelTest {

    @Test
    fun mergeSortTest(){
        val mainViewModel = MainViewModel()
        val array = mainViewModel.resetArray()
        val kotlinSort = array.sort()
        val mergeSort = mainViewModel.mergeSort(array, 0, array.size-1)
        assert(kotlinSort == mergeSort)
    }
}