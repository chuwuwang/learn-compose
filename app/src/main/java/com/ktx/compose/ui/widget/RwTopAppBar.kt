package com.ktx.compose.ui.widget

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.ktx.compose.ui.theme.Dimens
import com.ktx.compose.ui.theme.Fonts
import com.ktx.compose.ui.theme.LemonPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RwTopAppBar(text: String) {
    val style = TextStyle(fontSize = Dimens.sp_20, fontFamily = Fonts.bold, color = Color.White)
    val colors = TopAppBarDefaults.topAppBarColors(containerColor = LemonPrimary, titleContentColor = Color.White)
    TopAppBar(title = { Text(text = text, style = style) }, colors = colors)
}