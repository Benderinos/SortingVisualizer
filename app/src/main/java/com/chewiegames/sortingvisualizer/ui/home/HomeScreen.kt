package com.chewiegames.sortingvisualizer.ui.home

import androidx.compose.Composable
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.tooling.preview.Preview
import com.chewiegames.sortingvisualizer.ui.Screen
import com.chewiegames.sortingvisualizer.ui.navigateTo

@Preview
@Composable
fun HomeScreen() {
    Center {
        FlexColumn(mainAxisAlignment = MainAxisAlignment.Center) {
            flexible(1f) {
                Column {
                    FloatingActionButton(text = "Start Sorting Visualizer", onClick = { navigateTo(Screen.SortScreen) })
                }
            }
        }
    }
}