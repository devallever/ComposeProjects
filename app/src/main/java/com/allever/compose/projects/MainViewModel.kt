package com.allever.compose.projects

import androidx.lifecycle.ViewModel
import app.allever.android.learning.project.compose.data.FunctionItem

class MainViewModel : ViewModel() {

    val functionItemList = mutableListOf<FunctionItem>()

    init {
        initFunctionListData()
    }

    private fun initFunctionListData() {
        functionItemList.add(FunctionItem("微信", "微信主界面"))
        functionItemList.add(FunctionItem("天聊", "天聊Compose"))
        functionItemList.add(FunctionItem("虚构", "扔物线compose教程，虚构app"))
        functionItemList.add(FunctionItem("GoogleCompose", "Google Compose 教程"))
    }
}