package com.allever.compose.project.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.allever.compose.core.toast
import com.allever.compose.core.ui.ComposeProjectTheme

/**
 *@Description
 *@author: zq
 *@date: 2024/3/15
 */
class ListWidgetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "垂直列表 LazyColumn",
                        Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold
                    )

                    val list = mutableListOf<User>().apply {
                        add(User(System.currentTimeMillis(), "Allever", R.drawable.default_image))
                        add(User(System.currentTimeMillis(), "Winchen", R.drawable.default_image))
                        add(
                            User(
                                System.currentTimeMillis(),
                                "Devallever",
                                R.drawable.default_image
                            )
                        )
                    }
                    LazyColumn {
                        itemsIndexed(list) { index, item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .height(72.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = item.avatar),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(
                                            RoundedCornerShape(10.dp)
                                        )

                                )

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(64.dp)
                                        .padding(horizontal = 10.dp)
                                ) {
                                    Text(
                                        text = item.id.toString(),
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        color = Color.Black
                                    )

                                    Text(
                                        text = item.name,
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        color = Color.LightGray
                                    )
                                }
                            }
                        }
                    }

                    Text(
                        text = "水平列表 LazyRow",
                        Modifier.padding(10.dp),
                        fontWeight = FontWeight.Bold
                    )

                    val rowList = mutableListOf<Int>().apply {
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                        add(R.drawable.default_image)
                    }
                    LazyRow {
                        itemsIndexed(rowList) { index, item ->
                            Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                                Image(
                                    painter = painterResource(id = item),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(64.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .clickable {
                                            toast("click $index")
                                        }
                                )
                            }
                        }
                    }
                }
            }

        }
    }

    private inner class User(val id: Long, val name: String, val avatar: Int)
}