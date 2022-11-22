package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data
import com.vendhan.tomatoo.utils.toDp

@Composable
fun CardViewComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                start = value.padding?.toDp() ?: 0.dp,
                end = value.padding?.toDp() ?: 0.dp
            )
            .wrapContentSize(),
        shape = RoundedCornerShape(
            size = value.cornerRadius.toDp() ?: 4.dp
        )
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
