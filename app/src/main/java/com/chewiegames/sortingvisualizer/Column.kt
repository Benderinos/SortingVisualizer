package com.chewiegames.sortingvisualizer

import androidx.ui.graphics.Color

data class Column (var id: Int,
                   var value: Int,
                   var animations : Map<Int, Int>,
                   var color: Color)