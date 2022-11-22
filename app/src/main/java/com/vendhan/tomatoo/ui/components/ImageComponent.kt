package com.vendhan.tomatoo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vendhan.tomatoo.R
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data
import com.vendhan.tomatoo.utils.toDp

@Composable
fun ImageComponent(
    value: Data,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(value.value)
            .crossfade(true)
            .placeholder(R.drawable.place_holder_image)
            .build(),
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(
                start = value.padding.toDp() ?: 0.dp,
                end = value.padding.toDp() ?: 0.dp,
                top = value.padding.toDp() ?: 0.dp,
                bottom = value.padding.toDp() ?: 0.dp
            )
            .size(
                width = value.width.toDp() ?: 0.dp,
                height = value.height.toDp() ?: 0.dp
            )
            .clip(
                shape = RoundedCornerShape(value.cornerRadius.toDp() ?: 0.dp)
            )
            .clickable {
                onClickAction(
                    value.action,
                    value.id ?: ""
                )
            }
    )
}
