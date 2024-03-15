package com.allever.compose.project.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.allever.compose.core.TextClickItem
import com.allever.compose.core.toast
import com.allever.compose.core.ui.FunctionList

/**
 *@Description
 *@author: zq
 *@date: 2024/3/15
 */
class ComposeBasicMainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunctionList(list = mutableListOf<TextClickItem>().apply {
                add(TextClickItem("基础控件", "基础控件基本用法") {
                    toast(it.title)
                })
            })
        }
    }
}