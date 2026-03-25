package com.ktx.compose.sdui

import android.content.Context
import com.bot.nova.component.row.NovaHStack
import com.bot.nova.component.row.NovaHStackComponent
import com.bot.nova.component.row.NovaHStackStyle
import com.bot.nova.mode.NovaComponent

object SDUIContainerConverter {

    fun buildNovaComponent(context: Context, component: SDUIComponent): NovaComponent {
        val type = component.type
        if (type == "text") {
            return SDUIComponentConverter.buildNovaTextComponent(context, component)
        } else if (type == "button") {
            return SDUIComponentConverter.buildNovaButtonComponent(context, component)
        } else if (type == "hStack") {
            return buildNovaHStackComponent(context, component)
        }
        throw IllegalArgumentException("Unsupported component type: $type")
    }

    private fun buildNovaHStackComponent(context: Context, component: SDUIComponent): NovaHStackComponent {
        val style = component.style
        val hStackStyle = if (style != null) {
            NovaHStackStyle(
                width = style.width,
                height = style.height,
                padding = SDUIUtil.buildNovaPadding(style.padding),
                borderRadius = style.borderRadius ?: 0,
                backgroundColor = style.backgroundColor ?: NovaHStack.DEFAULT_BACKGROUND_COLOR,
            )
        } else {
            NovaHStackStyle()
        }
        val alignment = component.alignment ?: NovaHStack.DEFAULT_ALIGNMENT
        val children = if (component.children != null) {
            component.children.map { buildNovaComponent(context, it) }
        } else {
            emptyList()
        }
        val event = SDUIUtil.buildNovaAction(context, component.actions)
        return NovaHStackComponent(id = component.id, type = component.type, event = event, style = hStackStyle, alignment = alignment, children = children)
    }

}
