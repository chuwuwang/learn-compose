package com.ktx.compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LemonLightColorScheme = lightColorScheme(
    primary = Color(0xFFF4D03F),       // 柠檬黄（主色）
    onPrimary = Color(0xFF3A2F00),

    secondary = Color(0xFFFFE66D),     // 浅柠檬
    onSecondary = Color(0xFF3A2F00),

    tertiary = Color(0xFFB7E778),      // 柠檬青（点缀）
    onTertiary = Color(0xFF1F3A00),

    background = Color(0xFFFFFDE7),    // 很淡的柠檬白
    onBackground = Color(0xFF1C1B1F),

    surface = Color(0xFFFFFFF8),
    onSurface = Color(0xFF1C1B1F),

    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF)
)

val LemonDarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFE066),       // 柔和柠檬
    onPrimary = Color(0xFF3A2F00),

    secondary = Color(0xFFD4C94A),
    onSecondary = Color(0xFF2A2500),

    tertiary = Color(0xFF9CCC65),
    onTertiary = Color(0xFF1A2F00),

    background = Color(0xFF1C1B1F),
    onBackground = Color(0xFFE6E1E5),

    surface = Color(0xFF2C2B30),
    onSurface = Color(0xFFE6E1E5),

    error = Color(0xFFF2B8B5),
    onError = Color(0xFF601410)
)

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
)

private val LightColorScheme = lightColorScheme(
    primary = LemonPrimary,
    secondary = LemonLight,
    tertiary = LemonDark,
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun KTXTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        // dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        //     val context = LocalContext.current
        //     if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        // }
        darkTheme -> LemonDarkColorScheme
        else -> LemonLightColorScheme
    }
    MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}