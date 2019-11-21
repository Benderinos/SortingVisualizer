package com.chewiegames.sortingvisualizer.ui.home

import android.content.res.Resources
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Image
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Card
import androidx.ui.tooling.preview.Preview
import com.chewiegames.sortingvisualizer.R
import com.chewiegames.sortingvisualizer.ui.*

@Composable
fun HomeScreen(mainActivity: MainActivity) {
    Center {
        FlexColumn(mainAxisAlignment = MainAxisAlignment.Center) {
            HorizontalScroller {
                Column {
                    Row {
                        SortCards("Merge Sort", Screen.MergeSortScreen, imageFromResource (mainActivity.resources, R.mipmap.mergesort))
                        SortCards("Bubble Sort \n- in progress...", Screen.BubbleSortScreen, imageFromResource (mainActivity.resources, R.mipmap.bubblesort))
                        SortCards("Quick Sort \n- in Progress..", Screen.BubbleSortScreen, imageFromResource (mainActivity.resources, R.mipmap.quicksort))
                        SortCards("Heap Sort \n- in Progress..", Screen.HeapSortScreen, imageFromResource (mainActivity.resources, R.mipmap.heapsort))
                        SortCards("Shell Sort \n- in Progress..", Screen.HeapSortScreen, imageFromResource (mainActivity.resources, R.mipmap.shellsort))
                    }
                    //https://www.google.com/search?biw=1920&bih=969&tbm=isch&sxsrf=ACYBGNQ28igqFC3vScT4DjKFQpunNIM4yA%3A1574374046900&sa=1&ei=ngrXXcu2NtKSlwTC-ruoAg&q=merge+art&oq=merge+art&gs_l=img.3..35i39j0i19j0i5i30i19j0i8i30i19l3.50920.51428..51543...0.0..0.85.291.4......0....1..gws-wiz-img.......0j0i67j0i30.9J4-ejCPBL8&ved=0ahUKEwjL_buuqPzlAhVSyYUKHUL9DiUQ4dUDCAc&uact=5#imgrc=LG_jRHpzy71_5M:
                }
            }
        }
    }
}

@Preview
@Composable
fun SortCards(text: String, destination: Screen, image: Image) {
    Padding(padding = 24.dp) {
        Card(shape = RoundedCornerShape(4.dp)) {
            Ripple(bounded = true) {
                Clickable(onClick = {
                    if (destination == Screen.MergeSortScreen) navigateTo(destination)
                }) {
                    Container(width = 350.dp, height = 250.dp) {
                        Column(
                                mainAxisSize = LayoutSize.Expand,
                                crossAxisSize = LayoutSize.Expand
                        ) {
                            DrawImage(image)
                            Padding(top = 16.dp, bottom = 16.dp, right = 2.dp, left = 8.dp) {
                                Container(expanded = true, alignment = Alignment.TopRight) {
                                    Text(text = text, style = themeTypography.body1)

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}