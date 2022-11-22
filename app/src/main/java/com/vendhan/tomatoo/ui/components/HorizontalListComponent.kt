package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun HorizontalListComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            SetView(
                data = value.children ?: ArrayList(),
                applicationContext = applicationContext,
                lifecycleScope = lifecycleScope,
                onClickAction = { actionType, id ->
                    onClickAction(
                        actionType,
                        id
                    )
                }
            )
        }
    }
}
