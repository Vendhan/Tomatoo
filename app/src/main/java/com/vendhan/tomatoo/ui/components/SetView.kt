@file:OptIn(ExperimentalPagerApi::class)

package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import com.google.accompanist.pager.ExperimentalPagerApi
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data
import com.vendhan.tomatoo.repo.model.ViewType
import com.vendhan.tomatoo.ui.view.home_screen.ShowScaffold
import com.vendhan.tomatoo.ui.view.home_screen.ShowToolBar

@Composable
fun SetView(
    data: ArrayList<Data>,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (ActionType, String) -> Unit
) {
    data.forEach { value ->
        checkUiType(
            value = value,
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

@Composable
private fun checkUiType(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (ActionType, String) -> Unit
) {
    when (value.viewType) {
        ViewType.UNKNOWN -> TODO()
        ViewType.SCAFFOLD -> ShowScaffold(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(
                    actionType,
                    id
                )
            }
        )
        ViewType.APP_BAR -> ShowToolBar()
        ViewType.ROW -> RowComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(
                    actionType,
                    id
                )
            }
        )
        ViewType.COLUMN -> ColumnComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(
                    actionType,
                    id
                )
            }
        )
        ViewType.VERTICAL_LIST -> VerticalListComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(
                    actionType,
                    id
                )
            }
        )
        ViewType.HORIZONTAL_LIST -> HorizontalListComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(
                    actionType,
                    id
                )
            }
        )
        ViewType.CARD -> CardViewComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                onClickAction(
                    actionType,
                    id
                )
            }
        )
        ViewType.TEXT -> TextComponent(
            value = value
        )
        ViewType.IMAGE -> ImageComponent(
            value = value
        ) { actionType, id ->
            onClickAction(
                actionType,
                id
            )
        }
        ViewType.EDIT_TEXT -> TODO()
        ViewType.SLIDER -> HorizontalSliderComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = {
                // onClickAction(it)
            }
        )
        ViewType.VERTICAL_SPACER -> VerticalSpacerComponent(value = value)
        ViewType.HORIZONTAL_SPACER -> HorizontalSpacerComponent(value = value)
        ViewType.SIMPLE_HEADER_TEXT -> HeaderTextComponent(value = value)
        ViewType.HEADER_WITH_BUTTON -> HeaderWithButtonComponent(
            value = value,
            onClickAction = { actionType, id ->
                onClickAction(
                    actionType,
                    id
                )
            }
        )
        ViewType.BOX -> BoxComponent(
            value = value,
            applicationContext = applicationContext,
            lifecycleScope = lifecycleScope,
            onClickAction = { actionType, id ->
                // onClickAction(it)
            }
        )
        ViewType.RATING -> RatingViewComponent(value = value)
    }
}
