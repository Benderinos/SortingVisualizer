package com.chewiegames.sortingvisualizer.ui

import androidx.compose.Composable
import androidx.ui.animation.Crossfade
import androidx.ui.material.MaterialTheme
import com.chewiegames.sortingvisualizer.ui.home.HomeScreen
import com.chewiegames.sortingvisualizer.ui.sorting.SortScreen

@Composable
fun App(context: android.content.Context) {
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