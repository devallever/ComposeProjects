package com.allever.compose.projects

import com.allever.compose.core.App
import com.allever.compose.project.compose.ad.AdMobManager


/**
 *@Description
 *@author: zq
 *@date: 2024/1/4
 */
class MyApp: App() {
    override fun init() {
        AdMobManager.init(this)
    }
}