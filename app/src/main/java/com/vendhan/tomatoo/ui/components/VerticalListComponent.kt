package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun VerticalListComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = value.padding?.toFloat()?.dp ?: 0.dp,
            end = value.padding?.toFloat()?.dp ?: 0.dp
        ),
        modifier = Modifier
            .fillMaxSize()
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
