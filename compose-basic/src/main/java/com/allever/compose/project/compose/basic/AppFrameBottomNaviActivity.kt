package com.allever.compose.project.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Tab
import androidx.compose.material3.Icon
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.allever.compose.core.toast
import com.allever.compose.core.ui.ComposeProjectTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class AppFrameBottomNaviActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    //顶部状态栏，视频全面屏
                    Box(modifier = Modifier.fillMaxWidth())

                    //中部主界面
                    var pageIndex = rememberPagerState(0)
                    var tabIndex by remember {
                        mutableIntStateOf(0)
                    }

                    
                    LaunchedEffect(pageIndex) {
                        snapshotFlow { pageIndex.currentPage }.collect {
                            tabIndex = it
                        }
                    }

                    HorizontalPager(
                        count = 3, state = pageIndex, modifier = Modifier
                            .weight(1f)
                            .background(
                                Color(0X80FF0000)
                            )
                    ) {
                        when (it) {
                            0 -> {
                                Text(text = "FirstPage", modifier = Modifier.fillMaxSize())
                            }

                            1 -> {
                                Text(text = "SecondPage", modifier = Modifier.fillMaxSize())
                            }

                            2 -> {
                                Text(text = "ThirdPage", modifier = Modifier.fillMaxSize())
                            }
                        }
                    }

                    //底部导航栏
//                    var tabIndex by remember {
//                        mutableIntStateOf(0)
//                    }
                    val tabTitles = listOf("Tab1", "Tab2", "Tab3")
                    TabRow(selectedTabIndex = tabIndex, divider = {}, indicator = {}) {
                        tabTitles.forEachIndexed { index, s ->
                            Tab(
                                selectedContentColor = Color.Black,
                                unselectedContentColor = Color.Gray,
                                selected = tabIndex == index,
                                onClick = {
                                    tabIndex = index
                                    lifecycleScope.launch {
                                        pageIndex.scrollToPage(index)
                                    }
                                }) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_menu),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(32.dp)
                                            .padding(6.dp)
                                    )
                                    Text(
                                        text = s,
                                        modifier = Modifier.padding(2.dp),
                                        fontWeight = if (tabIndex == index) FontWeight.Bold else FontWeight.Light
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}