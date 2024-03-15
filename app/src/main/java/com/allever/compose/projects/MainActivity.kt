package com.allever.compose.projects

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.allever.android.learning.project.compose.data.FunctionItem
import app.allever.android.learning.project.compose.module.tianliao.module.main.TLMainActivity
import app.allever.android.learning.project.compose.module.wechat.ui.WechatComposeActivity
import app.allever.android.learning.project.compose.ui.theme.ComposeProjectTheme
import com.allever.compose.core.ActivityHelper
import com.allever.compose.core.TextClickItem
import com.allever.compose.core.ui.FunctionList
import com.allever.compose.project.compose.basic.ComposeBasicMainActivity
import com.allever.compose.project.google.GoogleComposeMainActivity
import com.allever.compose.project.watch.WatchMainActivity
import com.allever.compose.project.wechat.R

class MainActivity : ComponentActivity() {
    private val viewMode: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                //功能列表
                FunctionList(list = mutableListOf<TextClickItem>().apply {
                    add(TextClickItem("微信", "微信主界面") {
                        WechatComposeActivity.start(this@MainActivity)
                    })
                    add(TextClickItem("天聊", "天聊Compose") {
                        ActivityHelper.startActivity(TLMainActivity::class.java, this@MainActivity)
                    })
                    add(TextClickItem("虚构", "扔物线compose教程，虚构app") {
                        ActivityHelper.startActivity<WatchMainActivity>(this@MainActivity) {  }
                    })
                    add(TextClickItem("GoogleCompose", "Google Compose 教程") {
                        ActivityHelper.startActivity<GoogleComposeMainActivity>(this@MainActivity) {  }
                    })
                    add(TextClickItem("Compose Basic", "Compose 基础") {
                        ActivityHelper.startActivity<ComposeBasicMainActivity> (this@MainActivity){  }
                    })
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFunctionList() {
    val list = mutableListOf<FunctionItem>()
    list.add(FunctionItem("Title", "desc"))
    LazyColumn() {
        itemsIndexed(list) { index, item ->
            Column(
                Modifier
                    .fillMaxSize()
            ) {
                Text(item.title, fontSize = 14.sp)
                Text(item.desc, fontSize = 11.sp)
                Image(painterResource(R.drawable.avatar_me), contentDescription = "")
            }

        }
    }
}

