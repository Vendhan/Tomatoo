package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun RowComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        // horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
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
