package com.vendhan.tomatoo.ui.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ListScreen(
    categoryName: String
) {
    Text(text = "This is Details Screen $categoryName")
}
