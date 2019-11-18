package com.chewiegames.sortingvisualizer.ui

import android.os.Handler
import androidx.compose.Model
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.ui.graphics.Color
import com.chewiegames.sortingvisualizer.Column
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlin.math.floor

@Model
object MainViewModel {

    var columns = emptyList<Column>()
    private var color = Color.Red

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

    fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()

    fun mergeSort(array: List<Column>): List<Column> {
        //doMergeSort(array)
        return doMergeSort(array)
    }

    private fun getMergeAnimations(array: List<Column>): List<Int> {
        return getMergeSortAnimations(array)
    }

    fun onMergeSortSelected() {
        val animations = getMergeAnimations(columns)
        for (i in animations.indices) {
            val isColorChange = i % 3 != 2
            if (isColorChange) {
                var (barOneIndex, barTwoIndex) = animations[i]

                Handler().postDelayed({
                    val columnOne = columns[animations[i]]
                    val columnTwo = columns[animations[i]]
                    val color = if (i % 3 == 0) Color.Cyan else Color.Magenta
                    columns[columnOne.id].color = color
                    columns[columnTwo.id].color = color
                }, i * ANIMATION_SPEED)
            } else {
                Handler().postDelayed({
                    val (barOneIndex, newHeight) = animations[i]
                    val columnOne = columns[animations[i]]
                    columns[columnOne.id].value = animations[i]
                }, i * ANIMATION_SPEED)
            }
        }
        color = Color.Green
    }

    fun onColumnSelected(column: Column) {
        columns[column.id].color = Color.Yellow
        color = Color.Yellow
    }

    fun onNewSelected() = resetArray()
}