package com.vendhan.tomatoo.ui.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomBarNavigationItems(
    val icon: ImageVector,
    val iconSelected: ImageVector
) {
    Food(
        icon = Icons.Outlined.Home,
        iconSelected = Icons.Filled.Home
    ),
    Search(
        icon = Icons.Outlined.Search,
        iconSelected = Icons.Filled.Search
    ),
    Account(
        icon = Icons.Outlined.FavoriteBorder,
        iconSelected = Icons.Filled.Favorite
    );

    companion object {
        fun fromRoute(route: String?): BottomBarNavigationItems =
            when (route?.substringBefore("/")) {
                Food.name -> Food
                Search.name -> Search
                Account.name -> Account
                null -> Food
                else -> Food
            }
    }
}
