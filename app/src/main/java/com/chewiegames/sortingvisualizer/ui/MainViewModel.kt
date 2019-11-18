package com.chewiegames.sortingvisualizer.ui

import android.app.Activity
import android.os.Handler
import androidx.compose.Model
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.ui.graphics.Color
import com.chewiegames.sortingvisualizer.Column
import com.chewiegames.sortingvisualizer.algorithms.*
import kotlinx.coroutines.*
import kotlin.collections.ArrayList
import kotlin.math.floor

private const val TAG = "MainViewModel"

@Model
object MainViewModel {

    var columns = arrayListOf<Column>()
    private var color = Color.Red

    fun resetArray(): ArrayList<Column> {
        val tempColumns = arrayListOf<Column>()
        GlobalScope.launch(Dispatchers.Main) {
            for (i in 0 until NUMBER_OF_ARRAY_BARS) {
                tempColumns.add(Column(i, randomNumberFromIntervals(5, SIZE_COLUMN), hashMapOf(), Color.Red))
                columns = tempColumns
                delay(ANIMATION_SPEED)
            }
            color = Color.Red
        }
        return tempColumns
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
        GlobalScope.launch(Dispatchers.Main) {
            val animations = getMergeSortAnimationsNew(columns)
            for (i in 0 until animations.size) {
                val isColorChange = i % 3 != 2
                if (isColorChange) {
                    val columnOne = columns[animations[i] as Int]
                    val columnTwo = columns[animations[i] as Int]
                    val color = if (i % 3 == 0) Color.Cyan else Color.Magenta
                    delay(ANIMATION_SPEED)
                    columns[columnOne.id].color = color
                    columns[columnTwo.id].color = color
                } else {
                    delay(ANIMATION_SPEED)
                    val column = columns[animations[i] as Int]
                    columns[column.id].value = animations[i] as Int

                }
            }
            color = Color.Green
//            columns = mergeSort(columns)
        }
    }

    fun onColumnSelected(column: Column) {
        columns[column.id].color = Color.Yellow
        color = Color.Yellow
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