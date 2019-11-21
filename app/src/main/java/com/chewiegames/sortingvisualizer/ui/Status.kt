package com.chewiegames.sortingvisualizer.ui

import androidx.compose.Model

/**
 * Class defining the screens we have in the app: home, article details and interests
 */
sealed class Screen {
    object Home : Screen()
    object MergeSortScreen : Screen()
    object BubbleSortScreen : Screen()
    object HeapSortScreen : Screen()
}

@Model
object SortingAppStatus {
    var currentScreen: Screen = Screen.Home
}

/**
 * Temporary solution pending navigation support.
 */
fun navigateTo(destination: Screen) {
    SortingAppStatus.currentScreen = destination
}