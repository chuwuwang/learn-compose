package com.ktx.compose.ui.widget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.ktx.compose.ui.theme.AppColors
import com.ktx.compose.ui.theme.Dimens
import com.ktx.compose.ui.theme.Fonts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RwTopAppBar(text: String) {
    val style = TextStyle(fontSize = Dimens.sp_20, fontFamily = Fonts.bold, color = Color.White)
    val colors = TopAppBarDefaults.topAppBarColors(containerColor = AppColors.primary, titleContentColor = Color.White)
    TopAppBar(title = { Text(text = text, style = style) }, colors = colors)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RwTopAppBar(text: String, onBackClick: () -> Unit) {
    val style = TextStyle(fontSize = Dimens.sp_20, fontFamily = Fonts.bold, color = Color.White)
    val colors = TopAppBarDefaults.topAppBarColors(containerColor = AppColors.primary, titleContentColor = Color.White, navigationIconContentColor = Color.White)
    val navigationIcon: @Composable () -> Unit = {
        IconButton(onClick = onBackClick) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }
    }
    TopAppBar(title = { Text(text = text, style = style) }, colors = colors, navigationIcon = navigationIcon)
}