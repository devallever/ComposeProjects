package com.allever.compose.project.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.allever.compose.core.toast

/**
 *@Description
 *@author: zq
 *@date: 2024/3/15
 */
class BasicWidgetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            //线性布局, 占满全屏
            Column(
                modifier = Modifier
                    .fillMaxWidth()//占满宽度
                    .fillMaxHeight()//占满高度
                    .verticalScroll(
                        rememberScrollState()//垂直滚动
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "滚动布局 verticalScroll", Modifier.padding(10.dp))

                Text(
                    text = "文本用 Text",
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.Cyan),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(text = "本地图片 Image", Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.default_image),
                    contentDescription = ""
                )

                Text(text = "本地图片(圆角), clip(RoundedCornerShape(10.dp))", Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.default_image),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .width(100.dp)
                )

                Text(text = "本地图片(圆形), clip(CircleShape)", Modifier.padding(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.default_image),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .width(200.dp)
                )

                Text(text = "网络图片, AsyncImage", Modifier.padding(10.dp))
                AsyncImage(
                    model = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F81%2Ff8%2Fc2%2F81f8c2d8bea55c7b77ba0c4446f2e6a1.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1670503104&t=7dec4bfe2fb8646de9f063bc6aa92e0d",
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                )

                Text(text = "按钮 Button, 要包裹Text", Modifier.padding(10.dp))

                Button(
                    onClick = {
                        toast("click button")
                    }, modifier = Modifier
                        .width(200.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff000000),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Click Me")
                }

                Text(text = "输入框 BasicTextField", Modifier.padding(10.dp))

                var content by remember { mutableStateOf("") }
                Row(
                    modifier = Modifier
                        .width(200.dp)
                        .height(56.dp)
                        .clip(RoundedCornerShape(10.dp))//要写在background上面
                        .background(color = Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = content, onValueChange = {
                            content = it
                        }, modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth(),
                        singleLine = true
                    ) {
                        if (content.isEmpty()) {
                            androidx.compose.material.Text(
                                text = "请输入内容",
                                color = Color(0xffb4b4b4),
                                fontSize = 16.sp
                            )
                        }
                        it()
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Button(
                    onClick = {
                        if (content.isEmpty()) {
                            toast("please input content")
                            return@Button
                        }
                        toast(content)
                    }, modifier = Modifier
                        .width(200.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xff000000),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Confirm")
                }









                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )


            }
        }
    }
}