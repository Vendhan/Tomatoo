package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.LifecycleCoroutineScope
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun ColumnComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    Column(
        horizontalAlignment = if (value.alignment.isNullOrEmpty()) Alignment.Start else Alignment.CenterHorizontally
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

/*
fun getModifier(value: Data): Modifier {

    return if (value.width != null) {
        Modifier
            .width(value.width.toDp() ?: 0.dp)
    } else Modifier
}
*/
