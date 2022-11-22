package com.vendhan.tomatoo.ui.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.vendhan.tomatoo.R
import com.vendhan.tomatoo.repo.model.Data

@ExperimentalPagerApi
@Composable
fun HorizontalSliderComponent(
    value: Data,
    applicationContext: Context,
    lifecycleScope: LifecycleCoroutineScope,
    onClickAction: (String) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 1
    )
    /*LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            tween<Float>(600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }*/
    val items = value.children
    HorizontalPager(
        count = items?.size ?: 0,
        state = pagerState,
        contentPadding = PaddingValues(
            horizontal = 24.dp,
        ),
    ) { currentPage ->
        val item = items?.get(currentPage)
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                },
            shape = RoundedCornerShape(8.dp),

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item?.value)
                    .crossfade(true)
                    .placeholder(R.drawable.placeholder_banner)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clickable {
                    }
            )
        }
    }
}
