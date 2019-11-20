package com.chewiegames.sortingvisualizer.ui.sorting

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.TopAppBar
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import com.chewiegames.sortingvisualizer.model.Column
import com.chewiegames.sortingvisualizer.ui.Screen
import com.chewiegames.sortingvisualizer.ui.VectorImageButton
import com.chewiegames.sortingvisualizer.ui.navigateTo
import com.chewiegames.sortingvisualizer.ui.sorting.MainViewModel.onColumnSelected
import com.chewiegames.sortingvisualizer.ui.sorting.MainViewModel.onMergeSortSelected
import com.chewiegames.sortingvisualizer.ui.sorting.MainViewModel.onNewSelected
import com.chewiegames.sortingvisualizer.R

@Preview
@Composable
fun SortScreen() {
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
    FlexColumn{
        inflexible {
            TopAppBar (color = Color.Transparent,
                    title = { Text("") },
                    navigationIcon = {
                        VectorImageButton(R.drawable.ic_baseline_arrow_back) {
                            navigateTo(Screen.Home)
                        }
                    }
            )
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