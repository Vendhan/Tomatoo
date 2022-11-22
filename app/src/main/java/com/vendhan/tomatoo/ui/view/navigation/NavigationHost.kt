package com.vendhan.tomatoo.ui.view.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vendhan.tomatoo.repo.model.ActionType
import com.vendhan.tomatoo.ui.view.DetailsScreen
import com.vendhan.tomatoo.ui.view.ListScreen
import com.vendhan.tomatoo.ui.view.home_screen.AccountScreen
import com.vendhan.tomatoo.ui.view.home_screen.HomeScreen
import com.vendhan.tomatoo.ui.view.home_screen.SearchScreen
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarNavigationItems.Food.name,
    ) {
        composable(BottomBarNavigationItems.Food.name) {
            HomeScreen(
                navigateToOtherScreen = { actionType, id ->
                    navController.navigate(
                        route = getScreenNameFromActionType(
                            actionType = actionType,
                            id = id
                        )
                    )
                }
            )
        }
        composable(BottomBarNavigationItems.Search.name) {
            SearchScreen()
        }
        composable(BottomBarNavigationItems.Account.name) {
            AccountScreen()
        }
        composable(
            route = Screen.ListScreen + "?${Screen.categoryName}={${Screen.categoryName}}",
            arguments = listOf(
                navArgument(name = Screen.categoryName) {
                    type = NavType.StringType
                }
            )
        ) {
            val categoryName = it.arguments?.getString(Screen.categoryName) ?: ""
            ListScreen(
                categoryName = categoryName
            )
        }
        composable(
            route = Screen.DetailScreen + "?${Screen.id}={${Screen.id}}",
            arguments = listOf(
                navArgument(
                    name = Screen.id
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getString(Screen.id) ?: ""
            DetailsScreen(
                id = id
            )
        }
    }
}

private fun getScreenNameFromActionType(actionType: ActionType, id: String): String {
    return when (actionType) {
        ActionType.UNKNOWN -> TODO()
        ActionType.LIST -> Screen.ListScreen + "?${Screen.categoryName}={${id}}"
        ActionType.DETAIL -> Screen.DetailScreen + "?${Screen.id}={${id}}"
    }
}
