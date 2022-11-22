package com.vendhan.tomatoo.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun HeaderTextComponent(
    value: Data
) {
    Text(
        modifier = Modifier.padding(16.dp),
        text = value.value,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold
    )
}
