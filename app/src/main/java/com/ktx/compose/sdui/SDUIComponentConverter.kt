package com.ktx.compose.sdui

import android.content.Context
import com.bot.nova.component.button.NovaButton
import com.bot.nova.component.button.NovaButtonComponent
import com.bot.nova.component.button.NovaButtonStyle
import com.bot.nova.component.text.NovaText
import com.bot.nova.component.text.NovaTextComponent
import com.bot.nova.component.text.NovaTextStyle

object SDUIComponentConverter {

    fun buildNovaTextComponent(context: Context, component: SDUIComponent): NovaTextComponent {
        val style = component.style
        val textStyle = if (style != null) {
            NovaTextStyle(
                width = style.width,
                height = style.height,
                padding = SDUIUtil.buildNovaPadding(style.padding),
                borderRadius = style.borderRadius ?: 0,
                backgroundColor = style.backgroundColor ?: NovaText.DEFAULT_BACKGROUND_COLOR,
                font = style.font ?: NovaText.DEFAULT_FONT,
                color = style.color ?: NovaText.DEFAULT_FONT_COLOR,
                textAlign = style.textAlign ?: NovaText.DEFAULT_TEXT_ALIGN,
                lineLimit = component.style.lineLimit ?: Int.MAX_VALUE,
            )
        } else {
            NovaTextStyle()
        }
        val event = SDUIUtil.buildNovaAction(context, component.actions)
        return NovaTextComponent(id = component.id, type = component.type, event = event, style = textStyle, text = component.text ?: "")
    }

    fun buildNovaButtonComponent(context: Context, component: SDUIComponent): NovaButtonComponent {
        val style = component.style
        val buttonStyle = if (style != null) {
            NovaButtonStyle(
                width = style.width,
                height = style.height,
                padding = SDUIUtil.buildNovaPadding(style.padding),
                borderRadius = style.borderRadius ?: 0,
                backgroundColor = style.backgroundColor ?: NovaButton.DEFAULT_BACKGROUND_COLOR,
                font = style.font ?: NovaButton.DEFAULT_FONT,
                color = style.color ?: NovaButton.DEFAULT_FONT_COLOR,
                textAlign = style.textAlign ?: NovaButton.DEFAULT_TEXT_ALIGN,
                lineLimit = component.style.lineLimit ?: Int.MAX_VALUE,
            )
        } else {
            NovaButtonStyle()
        }
        val event = SDUIUtil.buildNovaAction(context, component.actions)
        return NovaButtonComponent(id = component.id, type = component.type, event = event, style = buttonStyle, text = component.text ?: "")
    }

}
