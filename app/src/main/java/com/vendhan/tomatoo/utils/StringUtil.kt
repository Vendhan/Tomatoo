package com.vendhan.tomatoo.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vendhan.tomatoo.repo.model.Colors
import com.vendhan.tomatoo.repo.model.TextStyles
import com.vendhan.tomatoo.repo.model.TextType

fun String?.toDp(): Dp? {
    return this?.toFloat()?.dp
}

fun Colors?.toColorResource(): Color? {
    return when (this) {
        Colors.RED -> Color.Red
        Colors.WHITE -> Color.White
        Colors.BLUE -> Color.Blue
        else -> null
    }
}

fun TextType?.toFontWeight(): FontWeight? {
    return when (this) {
        TextType.BOLD -> FontWeight.Bold
        TextType.SEMI_BOLD -> FontWeight.SemiBold
        TextType.MEDIUM -> FontWeight.Medium
        TextType.NORMAL -> FontWeight.Normal
        TextType.LIGHT -> FontWeight.Light
        TextType.THIN -> FontWeight.ExtraLight
        else -> null
    }
}

@Composable
fun TextStyles?.toTextStyle(): TextStyle? {
    return when (this) {
        TextStyles.HEADLINE -> MaterialTheme.typography.h6
        TextStyles.TITLE -> MaterialTheme.typography.h6.copy(fontSize = 18.sp)
        TextStyles.SUBTITLE -> MaterialTheme.typography.subtitle2
        TextStyles.BODY -> MaterialTheme.typography.body1
        TextStyles.CAPTION -> MaterialTheme.typography.caption
        null -> null
    }
}
