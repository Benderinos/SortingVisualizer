package com.chewiegames.sortingvisualizer.ui

import android.content.Context
import android.os.Handler
import androidx.compose.Model
import androidx.compose.composer
import androidx.ui.graphics.Color
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlin.math.floor

private const val TAG = "MainViewModel"
@Model
object MainViewModel {

    var array = emptyList<Int>()
    var animations = mapOf<Int, Int>()
    var color = Color.Red

    fun resetArray(): ArrayList<Int> {
        val array = arrayListOf<Int>()
        for (i in 0 until NUMBER_OF_ARRAY_BARS) {
            Handler().postDelayed({
                array.add(randomNumberFromIntervals(5, 380))
                this.array = array
            }, i * ANIMATION_SPEED )
        }
        //MainViewModel.array = array
        color = Color.Red
        return array
    }

    private fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()

    fun mergeSort(array: List<Int>): List<Int> {
        MainViewModel.array = doMergeSort(array)
        return MainViewModel.array
    }

    fun getMergeAnimations(array: List<Int>): Map<Int, Int> {
        return getMergeSortAnimations(array)
    }

    fun onMergeSortSelected() {
        val animations = getMergeAnimations(array)
        for (i in 0 until animations.size) {
            val isColorChange = i % 3 != 0
            if (isColorChange) {
                val barOneIndex = animations.keys.toIntArray()[i]
                val barTwoIndex = animations[i] ?: error("jeje")
                val color = if (i % 3 == 0) Color.Cyan else Color.Magenta
                Handler().postDelayed({
                }, i * ANIMATION_SPEED)
            } else {
                val barOneIndex = animations.keys.toIntArray()[i]
                val barTwoIndex = animations[i]
                Handler().postDelayed({
                }, i * ANIMATION_SPEED)
            }
        }
        color = Color.Green
        mergeSort(array)
    }

    fun onColumnSelected(context: Context, column: String) {
        color = Color.Yellow
    }

    fun onNewSelected() {
        resetArray()
    }
}