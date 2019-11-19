package com.chewiegames.sortingvisualizer.ui

import android.app.Activity
import android.os.Handler
import androidx.compose.Model
import androidx.ui.core.Duration
import androidx.ui.graphics.Color
import androidx.ui.temputils.delay
import com.chewiegames.sortingvisualizer.Column
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlinx.coroutines.*
import kotlin.collections.ArrayList
import kotlin.math.floor

private const val TAG = "MainViewModel"

@Model
object MainViewModel {

    var columns = arrayListOf<Column>()
    private var animate = false

    fun resetArray() {
        columns = arrayListOf()
        val  job = GlobalScope.launch(Dispatchers.Main) {
            for (i in 0 until NUMBER_OF_ARRAY_BARS) {
                val column = Column(i, randomNumberFromIntervals(5, SIZE_COLUMN), hashMapOf(), Color.Red)
                columns.add(column)
                animate = true
                delay(0)
            }
        }
    }

    fun randomNumberFromIntervals(min: Int, max: Int) = floor(Math.random() * (max - min + 1) + min).toInt()

    fun mergeSort(array: List<Column>): List<Column> {
        //doMergeSort(array)
        return doMergeSort(array, arrayListOf())
    }

    fun onMergeSortSelected() {
        val animations = getMergeSortAnimations(columns)

        GlobalScope.launch(Dispatchers.Main) {
            for (i in 0 until animations.size) {
                val isColorChange = i % 3 != 2
                if (isColorChange) {
                    val (columnOneIndex, columnTwoIndex) = animations[i]
                    val columnOne = columns[columnOneIndex]
                    val columnTwo = columns[columnTwoIndex]
                    val newColor = if (i % 3 == 0) Color.Cyan else Color.Magenta
                    columns[columnOne.id].color = newColor
                    columns[columnTwo.id].color = newColor
                    animate = true
                    delay(10)
                } else {
                    val (columnOneIndex, newHeight) = animations[i]
                    val column = columns[columnOneIndex]
                    columns[column.id].value = newHeight
                    animate = true
                    delay(10)
                }
            }
            onComplete(Color.Green)
        }
    }

    private fun onComplete(finalColor: Color) {
        GlobalScope.launch(Dispatchers.Main) {
            for (i in columns.indices) {
                columns[i].color = finalColor
                animate = true
                delay(0)
            }
        }

    }

    fun onColumnSelected(column: Column) {
        columns[column.id].color = Color.Yellow
        animate = true
    }

    fun onNewSelected() = resetArray()

}

fun afterOnMain(delay: Long, activity: Activity, process: () -> Unit) {
    Handler().postDelayed({
        activity.runOnUiThread {
            process()
        }
    }, delay)
}