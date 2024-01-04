package app.allever.android.learning.project.compose.module.wechat.data

import androidx.annotation.DrawableRes
import com.allever.compose.project.wechat.R

data class User(val id: String, val nickname: String, @DrawableRes val avatar: Int) {
    companion object {
        val Me = User("alleve", "Allever", R.drawable.avatar_me)
    }
}