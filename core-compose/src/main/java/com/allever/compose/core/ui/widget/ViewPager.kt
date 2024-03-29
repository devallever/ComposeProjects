package com.allever.compose.core.ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.*


object ViewPager {
    const val Horizontal = 0
    const val Vertical = 1
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPager(
    count: Int,
    orientation: Int = ViewPager.Horizontal,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    onPageChanged: (Int) -> Unit,
    content: @Composable PagerScope.(page: Int) -> Unit
): Modifier {
    //页面切换监听
    LaunchedEffect(pagerState) {
        // Collect from the pager state a snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPageChanged(page)
        }
    }

    if (orientation == ViewPager.Horizontal) {
        HorizontalPager(count, modifier, pagerState, content = content)
    } else {
        VerticalPager(count, modifier, pagerState, content = content)
    }

    return modifier
}