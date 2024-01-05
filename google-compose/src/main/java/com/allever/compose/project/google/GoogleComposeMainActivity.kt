package com.allever.compose.project.google

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.allever.compose.project.google.ui.theme.GoogleComposeProjectsTheme

/**
 *@Description
 *@author: Allever
 *@date: 2024/1/5
 */
class GoogleComposeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleComposeProjectsTheme {
                MyApp()
            }
        }
    }


}

@Composable()
fun Greeting(name: String) {
    val expended = remember {
        mutableStateOf(false)
    }
    val expendedPadding = if (expended.value) 48.dp else 0.dp

    Surface(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(Modifier.padding(24.dp)) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(bottom = expendedPadding)) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(onClick = {
                expended.value = !expended.value
            }) {
                Text(text = if (expended.value) "Show less" else "Show more")
            }
        }

    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    nameList: List<String> = listOf("Compose Project", "Android")
) {
    //可以用 Surface 包围 可组合项, 设置背景颜色
    Column {
        for (name in nameList) {
            Greeting(name)
        }
    }
}
