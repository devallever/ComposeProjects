package com.allever.compose.project.compose.ad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.view.isVisible
import com.allever.compose.core.log
import com.allever.compose.core.ui.ComposeProjectTheme
import com.allever.compose.project.compose.ad.databinding.NativeAdSmallBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError

class AdMobNativeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "原生 Banner广告",
                        Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold
                    )

                    SmallNativeAd()

                }
            }
        }
    }

    @Composable
    fun SmallNativeAd() {
        val context = LocalContext.current
        val adId = Constants.NATIVE_TEST_ID
        var requested = false
        AndroidViewBinding(factory = NativeAdSmallBinding::inflate) {
            if (requested) {
                return@AndroidViewBinding
            }

            adNativeView.isVisible = false
            adNativeView.also { adNativeView ->
//                adView.adChoicesView = adChoice
                adNativeView.bodyView = adBody
                adNativeView.iconView = adIcon
                adNativeView.headlineView = adHeadline
                adNativeView.callToActionView = adCta
                adNativeView.mediaView = adMedia
                adNativeView.storeView = adStore
                adNativeView.priceView = adPrice

                kotlin.runCatching {
                    AdLoader.Builder(this@AdMobNativeActivity, adId)
                        .forNativeAd { nativeAd ->
                            adBody.text = nativeAd.body
                            adHeadline.text = nativeAd.headline
                            Glide.with(adIcon).load(nativeAd.icon?.drawable)
                                .transform(CenterInside(), RoundedCorners(8)).into(adIcon)
                            adCta.text = nativeAd.callToAction
                            nativeAd.mediaContent?.let {
                                adMedia.mediaContent = it
                            }
                            adStore.text = nativeAd.store
                            adPrice.text = nativeAd.price
                            adNativeView.setNativeAd(nativeAd)
                        }
                        .withAdListener(object : AdListener() {
                            override fun onAdLoaded() {
                                log("small native ad loaded")
                                adNativeView.isVisible = true
                            }

                            override fun onAdFailedToLoad(error: LoadAdError) {
                                log("small native ad fail to load: ${error.message}")
                            }

                            override fun onAdClosed() {

                            }
                        })
                }
                    .onSuccess {
                        it.build().loadAd(AdRequest.Builder().build())
                        requested = true
                    }
            }
        }

    }
}

