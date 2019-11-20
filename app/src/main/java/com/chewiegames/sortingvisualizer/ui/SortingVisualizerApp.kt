package com.chewiegames.sortingvisualizer.ui

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.animation.Crossfade
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeColor
import androidx.ui.tooling.preview.Preview
import com.chewiegames.sortingvisualizer.ui.home.HomeScreen
import com.chewiegames.sortingvisualizer.ui.sorting.SortScreen

@Preview
@Composable
fun App() {
    MaterialTheme(
            colors = lightThemeColors,
            typography = themeTypography
    ) {
        Crossfade(SortingAppStatus.currentScreen) { screen ->
            when (screen) {
                is Screen.Home -> HomeScreen()
                is Screen.SortScreen -> SortScreen()
            }
        }
    }
}