package com.chewiegames.sortingvisualizer.ui

import android.os.Handler
import androidx.compose.Model
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.ui.graphics.Color
import com.chewiegames.sortingvisualizer.Column
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlin.math.floor

private const val TAG = "MainViewModel"

@Model
object MainViewModel {

    var columns = emptyList<Column>()
    var animations = mapOf<Int, Int>()
    var color = Color.Red

    fun resetArray(): ArrayList<Column> {
        val columns = arrayListOf<Column>()
        for (i in 0 until NUMBER_OF_ARRAY_BARS) {
            Handler().postDelayed({
                columns.add(Column(i, randomNumberFromIntervals(5, SIZE_COLUMN), hashMapOf(), color))
                this.columns = columns
            }, i * ANIMATION_SPEED)
        }
        color = Color.Red
        return columns
    }

    private fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()

    fun mergeSort(array: List<Column>): List<Column> {
        this.columns = doMergeSort(array)
        return columns
    }

    fun getMergeAnimations(array: List<Column>): Map<Int, Int> {
        return getMergeSortAnimations(array)
    }

    fun onMergeSortSelected() {
        val animations = getMergeAnimations(columns)
        var i = 0
        for ((key, value) in animations) {
            val isColorChange = i % 3 != 0
            if (isColorChange) {
                val barOneIndex = key
                val barTwoIndex = value
                val color = if (i % 3 == 0) Color.Cyan else Color.Magenta
                Handler().postDelayed({
                    columns[barOneIndex].color = color
                    columns[barTwoIndex].color = color
                }, i * ANIMATION_SPEED)
            } else {
                Handler().postDelayed({
                    val barOneIndex = key
                    val newHeight = value
                    columns[barOneIndex].value = newHeight
                }, i * ANIMATION_SPEED)
            }
            i++
        }
        color = Color.Green
    }

    fun onColumnSelected(column: Column) {
        columns[column.id].color = Color.Yellow
        color = Color.Yellow
    }

    fun onNewSelected() = resetArray()
}