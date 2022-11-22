package com.vendhan.tomatoo.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun HorizontalSpacerComponent(
    value: Data,
) {
    Spacer(
        modifier = Modifier
            .width(value.width?.toFloat()?.dp ?: 0.dp)
    )
}
