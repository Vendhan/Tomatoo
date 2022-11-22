package com.vendhan.tomatoo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun VerticalSpacerComponent(
    value: Data,
) {
    Spacer(
        modifier = Modifier
            .height(value.height?.toFloat()?.dp ?: 0.dp)
    )
}
