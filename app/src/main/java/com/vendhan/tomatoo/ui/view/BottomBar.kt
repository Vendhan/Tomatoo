package com.vendhan.tomatoo.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vendhan.tomatoo.ui.view.navigation.BottomBarNavigationItems

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    items: List<BottomBarNavigationItems>,
    onTabSelected: (BottomBarNavigationItems) -> Unit,
    currentScreen: BottomBarNavigationItems
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
        BottomNavigation(
            modifier = modifier
                .height(68.dp)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                ),
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        if (item == currentScreen)
                            Icon(
                                imageVector = item.iconSelected,
                                contentDescription = null,
                            )
                        else
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = Color.White
                            )
                    },
                    label = {
                        Text(
                            text = item.name,
                            color = Color.White
                        )
                    },
                    selected = currentScreen == item,
                    onClick = {
                        onTabSelected(item)
                    },
                )
            }
        }
    }
}
