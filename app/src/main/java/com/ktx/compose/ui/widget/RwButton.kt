package com.ktx.compose.ui.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.ktx.compose.ui.theme.Dimens
import com.ktx.compose.ui.theme.Fonts


@Composable
fun RwButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(modifier = modifier.fillMaxWidth().height(Dimens.px_60), shape = RoundedCornerShape(Dimens.px_12), onClick = onClick) {
        Text(text = text, style = RwButton.ButtonTextStyle)
    }
}

object RwButton {

    val ButtonTextStyle: TextStyle
        get() = TextStyle(fontSize = Dimens.sp_16, fontFamily = Fonts.medium, color = Color.White)

}