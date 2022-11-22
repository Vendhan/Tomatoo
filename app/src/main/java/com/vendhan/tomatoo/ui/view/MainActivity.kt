package com.vendhan.tomatoo.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vendhan.tomatoo.ui.theme.TomatooTheme
import com.vendhan.tomatoo.ui.view.navigation.BottomBarNavigationItems
import com.vendhan.tomatoo.ui.view.navigation.NavigationHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TomatooTheme {
                val items = BottomBarNavigationItems.values().toList()
                val navController = rememberNavController()
                val backstackEntry = navController.currentBackStackEntryAsState()
                val currentScreen =
                    BottomBarNavigationItems.fromRoute(backstackEntry.value?.destination?.route)

                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(
                            items = items,
                            onTabSelected = { screen ->
                                if (screen != currentScreen) {
                                    navController.navigate(screen.name) {
                                        navController.popBackStack()
                                    }
                                }
                            },
                            currentScreen = currentScreen,
                        )
                    },
                    scaffoldState = scaffoldState
                ) {
                    NavigationHost(
                        navController = navController
                    )
                }
            }
        }
    }
}
