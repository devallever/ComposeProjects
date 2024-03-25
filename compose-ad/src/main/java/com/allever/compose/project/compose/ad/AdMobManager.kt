package com.allever.compose.project.compose.ad

import android.content.Context
import com.google.android.gms.ads.MobileAds

object AdMobManager {
    fun init(context: Context) {
        MobileAds.initialize(context) {
        }
    }
}