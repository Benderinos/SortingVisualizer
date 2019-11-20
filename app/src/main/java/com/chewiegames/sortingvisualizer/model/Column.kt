package com.chewiegames.sortingvisualizer.model

import androidx.ui.graphics.Color

data class Column (var id: Int,
                   var value: Int,
                   var animations : Map<Int, Int>,
                   var color: Color)