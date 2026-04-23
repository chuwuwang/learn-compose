package com.ktx.compose.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.ktx.compose.ui.BaseCMPActivity
import com.ktx.compose.ui.theme.Dimens
import com.ktx.compose.ui.theme.Fonts
import com.ktx.compose.ui.widget.ModifierUtils
import com.ktx.compose.ui.widget.RwTopAppBar
import kotlinx.coroutines.delay

class TypewriterTextActivity : BaseCMPActivity() {

    @Composable
    override fun Screen() {
        Column {
            RwTopAppBar("打字机效果") { finish() }

            TextTypeWriter(modifier = ModifierUtils.space_norm, text = "Hello World") {
                // 打字机效果完成后的回调
                Log.d("TypewriterTextActivity", "Screen: 打字机效果完成后的回调")
            }
        }
    }

}

@Composable
private fun TextTypeWriter(modifier: Modifier = Modifier, text: String, delayRange: LongRange = 10L..400L, onDone: () -> Unit) {
    var textToDisplay by remember { mutableStateOf("") }
    LaunchedEffect(key1 = text) {
        val random = delayRange.random()
        val arrays = text.toCharArray()
        for (char in arrays) {
            textToDisplay += char.toString()
            delay(timeMillis = random)
        }
        onDone.invoke()
    }
    val style = TextStyle(fontSize = Dimens.sp_18, fontFamily = Fonts.medium)
    Text(modifier = modifier, text = textToDisplay, style = style)
}