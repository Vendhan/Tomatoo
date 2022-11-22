package com.vendhan.tomatoo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data
import com.vendhan.tomatoo.utils.toColorResource

@Composable
fun HeaderWithButtonComponent(
    value: Data,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(16.dp)
                .weight(1.0f),
            text = value.value,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            color = value.color.toColorResource() ?: Color.Unspecified,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onClickAction(
                        value.action,
                        value.id ?: ""
                    )
                },
            text = "See More",
            style = MaterialTheme.typography.subtitle1,
            color = value.color.toColorResource() ?: MaterialTheme.colors.primaryVariant
        )
    }
}
