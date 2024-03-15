package com.allever.compose.project.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.allever.compose.core.ui.ComposeProjectTheme

/**
 *@Description
 *@author: zq
 *@date: 2024/3/15
 */
class GridWidgetActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {

            }
        }
    }
}