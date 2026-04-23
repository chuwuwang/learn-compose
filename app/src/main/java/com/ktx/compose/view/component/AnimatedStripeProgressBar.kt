package com.ktx.compose.view.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun AnimatedStripeProgressBar(
    modifier: Modifier = Modifier,
    progress: Float = 0f,
    height: Float = 24f,
    strokeWidth: Float = 2f,
    stripeColor: Color = Color(0xFF111827),
    bgColor: Color = Color.White,
    stripeWidth: Float = 12f,
    angle: Float = 45f,
    animationSpeed: Int = 300,
) {
    val animation = tween<Float>(durationMillis = animationSpeed, easing = LinearEasing)
    val animationSpec = infiniteRepeatable(animation = animation)
    val phase by rememberInfiniteTransition(label = "progress_phase")
        .animateFloat(initialValue = 0f, targetValue = 1f, animationSpec = animationSpec, label = "progress_phase")
    val brush = Brush.stripes(stripeColor to 1f, bgColor to 1f, width = stripeWidth, angle = angle, phase = -phase)

    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(width = strokeWidth.dp, color = stripeColor, shape = CircleShape)
            .height(height.dp)
            .fillMaxWidth()
            .drawBehind {
                val barWidth = size.width
                val filledWidth = barWidth * progress
                if (filledWidth > 0) {
                    drawRect(size = Size(filledWidth, size.height), brush = brush)
                }
            }
    )
}

private fun Brush.Companion.stripes(vararg stripes: Pair<Color, Float>, width: Float = 20f, angle: Float = 45f, phase: Float = 0f, ): Brush {
    val totalWeight = stripes.sumOf { it.second.toDouble() }.toFloat()

    val colorStops = mutableListOf<Pair<Float, Color>>()
    var currentPosition = 0f

    stripes.forEach { (color, weight) ->
        val proportion = weight / totalWeight
        colorStops.add(currentPosition to color)
        currentPosition += proportion
        colorStops.add(currentPosition to color)
    }

    val angleInRadians = angle * (PI / 180)
    val endX = (width * cos(angleInRadians)).toFloat()
    val endY = (width * sin(angleInRadians)).toFloat()

    val phaseOffsetX = endX * phase
    val phaseOffsetY = endY * phase

    return linearGradient(colorStops = colorStops.toTypedArray(), start = Offset(-phaseOffsetX, -phaseOffsetY), end = Offset(endX - phaseOffsetX, endY - phaseOffsetY), tileMode = TileMode.Repeated)
}