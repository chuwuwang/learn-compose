package com.ktx.compose.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.ktx.compose.R

object Fonts {

    private val boldFont = Font(resId = R.font.pmx_bold, weight = FontWeight.Bold)
    private val mediumFont = Font(resId = R.font.pmx_medium, weight = FontWeight.Medium)
    private val regularFont = Font(resId = R.font.pmx_regular, weight = FontWeight.Normal)
    private val lightFont = Font(resId = R.font.pmx_light, weight = FontWeight.Light)

    val bold = FontFamily(boldFont)

    val medium = FontFamily(mediumFont)

    val regular = FontFamily(regularFont)

    val light = FontFamily(regularFont)

}