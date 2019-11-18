package com.chewiegames.sortingvisualizer.ui

import android.app.Activity
import android.content.Context
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.layout.*
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.surface.Surface
import com.chewiegames.sortingvisualizer.Column
import com.chewiegames.sortingvisualizer.ui.MainViewModel.onColumnSelected
import com.chewiegames.sortingvisualizer.ui.MainViewModel.onMergeSortSelected
import com.chewiegames.sortingvisualizer.ui.MainViewModel.onNewSelected

@Composable
fun App(context: Activity) {
    MainViewModel.resetArray()
    FlexRow(mainAxisAlignment = MainAxisAlignment.Center) {
        expanded(1f) {
            for (column in MainViewModel.columns) {
                RenderColumn(column, onClick = {
                    onColumnSelected(column)
                })
            }
        }
    }
    Padding(padding = 16.dp) {
        Row {
            FabButton(fabText = "new", onClick = { onNewSelected() })
            WidthSpacer(width = 4.dp)
            FabButton(fabText = "sort", onClick = { onMergeSortSelected() })
        }
    }
}

@Composable
fun FabButton(fabText: String, onClick: () -> Unit) {
    Column(mainAxisSize = LayoutSize.Expand, mainAxisAlignment = MainAxisAlignment.End) {
        FloatingActionButton(
                text = fabText,
                onClick = onClick)
    }
}

@Composable
fun RenderColumn(column: Column, onClick: () -> Unit) {
    Clickable(onClick = onClick) {
        Padding(padding = 1.dp) {
            Align(alignment = Alignment.BottomCenter) {
                Column(crossAxisAlignment = CrossAxisAlignment.End) {
                    Container(width = 2.dp, height = column.value.dp) {
                        Surface(color = column.color) {
                            Align(alignment = Alignment.BottomCenter) {
                            }
                        }
                    }
                }
            }
        }
    }
}
