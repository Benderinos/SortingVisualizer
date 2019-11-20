package com.chewiegames.sortingvisualizer.ui.sorting

import android.os.Handler
import androidx.compose.Model
import androidx.ui.graphics.Color
import com.chewiegames.sortingvisualizer.algorithms.*
import com.chewiegames.sortingvisualizer.model.Column
import kotlinx.coroutines.*
import kotlin.math.floor

private const val TAG = "MainViewModel"

@Model
object MainViewModel {

    var columns = arrayListOf<Column>()
    private var animate = false

    fun resetArray() {
        columns = arrayListOf()
        for (i in 0 until NUMBER_OF_ARRAY_BARS) {
            Handler().postDelayed({
                val column = Column(i, randomNumberFromIntervals(5, SIZE_COLUMN), hashMapOf(), Color.Red)
                columns.add(column)
                animate = true
            }, i * ANIMATION_SPEED)
        }
    }

    fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()

    fun mergeSort(array: List<Column>) = doMergeSort(array, arrayListOf())

    fun onMergeSortSelected() {
        val animations = getMergeSortAnimations(columns)
        for (i in 0 until animations.size) {
            val isColorChange = i % 3 != 2
            if (isColorChange) {
                val (columnOneIndex, columnTwoIndex) = animations[i]
                val columnOne = columns[columnOneIndex]
                val columnTwo = columns[columnTwoIndex]
                val newColor = if (i % 3 == 0) Color.Cyan else Color.Red
                Handler().postDelayed({
                    columns[columnOne.id].color = newColor
                    columns[columnTwo.id].color = newColor
                    animate = true
                }, i * ANIMATION_SPEED)
            } else {
                Handler().postDelayed({
                    val (columnOneIndex, newHeight) = animations[i]
                    val column = columns[columnOneIndex]
                    columns[column.id].value = newHeight
                    animate = true
                    if(i==animations.size-1) onComplete(Color.Green)
                }, i * ANIMATION_SPEED)
            }
        }
    }

    private fun onComplete(finalColor: Color) {
        GlobalScope.launch(Dispatchers.Main) {
            for (i in columns.indices) {
                columns[i].color = finalColor
                animate = true
                delay(1)
            }
        }
    }

    fun onColumnSelected(column: Column) {
        columns[column.id].color = Color.Yellow
        animate = true
    }

    fun onNewSelected() = resetArray()
}
