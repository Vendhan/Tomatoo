package com.vendhan.tomatoo.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vendhan.tomatoo.repo.model.Data
import com.vendhan.tomatoo.utils.toColorResource
import com.vendhan.tomatoo.utils.toDp
import com.vendhan.tomatoo.utils.toFontWeight
import com.vendhan.tomatoo.utils.toTextStyle

@Composable
fun TextComponent(
    value: Data
) {
    Text(
        text = value.value,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
        fontWeight = value.textType.toFontWeight(),
        color = value.color.toColorResource() ?: Color.Unspecified,
        style = value.textStyle.toTextStyle() ?: TextStyle.Default,
        modifier = Modifier
            .padding(
                start = value.padding.toDp() ?: 0.dp,
                end = value.padding.toDp() ?: 0.dp,
                top = value.padding.toDp() ?: 0.dp,
                bottom = value.padding.toDp() ?: 0.dp
            )
    )
}
