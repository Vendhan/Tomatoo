package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LifecycleCoroutineScope
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data

@Composable
fun BoxComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
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
