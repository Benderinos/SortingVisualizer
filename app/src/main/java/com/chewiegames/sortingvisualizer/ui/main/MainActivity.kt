package com.chewiegames.sortingvisualizer.ui.main

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.lifecycle.ViewModelProvider
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.gestures.DragDirection
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.LinearProgressIndicator
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.vectormath64.rotation

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContent {
            MaterialTheme {
                App(viewModel)
            }
        }
    }
}

@Composable
fun App(viewModel: MainViewModel) {
    var array : State<IntArray> = +state {viewModel.array}
    Column {
        HorizontalScroller {
            Row(mainAxisSize = LayoutSize.Expand) {
                array.value.forEach {
                    RenderItem(it, onClick = { onSelected(it.toString()) })
                }

            }
        }
    }
    Padding(padding = 16.dp) {
        Row() {
            Column(mainAxisSize = LayoutSize.Expand, mainAxisAlignment = MainAxisAlignment.End) {
                FloatingActionButton(text = "new", onClick = {array.value = viewModel.resetArray()})
            }
            Column(mainAxisSize = LayoutSize.Expand, mainAxisAlignment = MainAxisAlignment.End) {
                FloatingActionButton(text = "sort", onClick = {array.value = viewModel.mergeSort(array.value)})
            }
        }

    }

}

@Composable
fun RenderItem(number: Int, onClick: () -> Unit) {
    Clickable(onClick = onClick) {
        Padding(padding = 1.dp) {
            FlexColumn() {
                Container(width = 1.dp, height = number.dp) {
                    Surface(color = Color.Red) {
                        Align(alignment = Alignment.BottomCenter) {
                        }
                    }
                }
            }
        }
    }
}

fun onSelected(column: String) {

}
