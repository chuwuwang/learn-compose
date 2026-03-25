package com.ktx.compose.sdui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.bot.nova.NovaLoader
import com.bot.nova.mode.NovaStyle

class SDUILoader {

    private val novaLoader = NovaLoader()

    @Composable
    fun Render(component: SDUIComponent) {
        val novaComponent = SDUIContainerConverter.buildNovaComponent(LocalContext.current, component)
        novaLoader.Render(novaComponent)
    }

    fun setText(id: String, text: String) {
        novaLoader.setText(id, text)
    }

    fun setEvent(id: String, onClick: () -> Unit) {
        novaLoader.setEvent(id, onClick)
    }

    fun updateStyle(id: String, style: NovaStyle) {
        novaLoader.updateStyle(id, style)
    }

    fun getStyle(id: String): NovaStyle ? {
        return novaLoader.getStyle(id)
    }

}
