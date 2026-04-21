package com.ktx.compose.ui.widget

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit

const val DEFAULT_MINIMUM_TEXT_LINE = 3

/**
 * A text component that provides access to truncated text with a dynamic ... Show More/Show Less button.
 */
@Composable
fun TruncateText(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    text: String,
    fontSize: TextUnit,
    fontStyle: FontStyle ? = null,
    textAlign: TextAlign ? = null,
    collapsedMaxLine: Int = DEFAULT_MINIMUM_TEXT_LINE,
    showMoreText: String = "... Show More",
    showMoreStyle: SpanStyle = SpanStyle(fontWeight = FontWeight.W500),
    showLessText: String = " Show Less",
    showLessStyle: SpanStyle = showMoreStyle,
) {
    // State variables to track the expanded state, clickable state, and last character index.
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableIntStateOf(0) }
    val interactionSource = remember { MutableInteractionSource() }

    // Box composable containing the Text composable.
    val modifier = Modifier
        .clickable(interactionSource = interactionSource, indication = null, clickable) { isExpanded = ! isExpanded }
        .then(modifier)
    Box(modifier = modifier) {
        // Text composable with buildAnnotatedString to handle "Show More" and "Show Less" buttons.
        val onTextLayout: (TextLayoutResult) -> Unit = { textLayoutResult ->
            if (textLayoutResult.hasVisualOverflow && ! isExpanded) {
                clickable = true
                lastCharIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
            }
        }
        val annotatedString = buildAnnotatedString {
            if (clickable) {
                if (isExpanded) {
                    // Display the full text and "Show Less" button when expanded.
                    append(text)
                    withStyle(style = showLessStyle) { append(showLessText) }
                } else {
                    // Display truncated text and "Show More" button when collapsed.
                    val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                        .dropLast(showMoreText.length)
                        .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                    append(adjustText)
                    withStyle(style = showMoreStyle) { append(showMoreText) }
                }
            } else {
                // Display the full text when not clickable.
                append(text)
            }
        }
        Text(
            modifier = textModifier.fillMaxWidth().animateContentSize(),
            text = annotatedString,
            style = style,
            fontSize = fontSize,
            textAlign = textAlign,
            fontStyle = fontStyle,
            // Callback to determine visual overflow and enable click ability.
            onTextLayout = onTextLayout,
            // Set max lines based on the expanded state.
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
        )
    }
}