package com.vendhan.tomatoo.ui.view.home_screen

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.repo.model.Data
import com.vendhan.tomatoo.repo.model.RemoteModel
import com.vendhan.tomatoo.ui.components.SetView
import com.vendhan.tomatoo.ui.view.MainViewModel
import com.vendhan.tomatoo.utils.Result

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navigateToOtherScreen: (ActionType,String) -> Unit
) {
    val data = mainViewModel.data

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val uiDataFlow = remember(data, lifecycleOwner) {
        data.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val uiData by uiDataFlow.collectAsState(Result.Loading)

    when (uiData) {
        is Result.Error -> ShowErrorComponent()
        Result.Loading -> ShowLoadingComponent()
        is Result.Success -> SetView(
            data = (uiData as Result.Success<RemoteModel>).data.data ?: ArrayList(),
            applicationContext = context,
            lifecycleScope = lifecycleOwner.lifecycleScope,
            onClickAction = { actionType, id ->
                navigateToOtherScreen(
                    actionType,
                    id
                )
            }
        )
    }
}

@Composable
fun ShowLoadingComponent() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
        )
    }
}

@Composable
fun ShowErrorComponent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "There is some problem"
        )
    }
}

@Composable
fun ShowToolBar() {
    Text(text = "This is ToolBar")
}

@Composable
fun ShowScaffold(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (actionType: ActionType, id: String) -> Unit
) {
    SetView(
        data = value.children ?: ArrayList(),
        applicationContext = applicationContext,
        lifecycleScope,
        onClickAction = { actionType, id ->
            onClickAction(
                actionType,
                id
            )
        }
    )
}

private fun getNavigationPath() {
    
}
