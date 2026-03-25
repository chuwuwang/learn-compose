package com.ktx.compose.sdui

import android.content.Context
import com.bot.nova.action.NovaEvent
import com.bot.nova.mode.NovaPadding

object SDUIUtil {

    fun buildNovaAction(context: Context, actions: List<SDUIAction> ?
    ): NovaEvent {
        if (actions == null || actions.size == 0) {
            return NovaEvent()
        }
        val event = NovaEvent()
        actions.forEach {
            if (it.event == "onClick") {

            } else if (it.event == "onLongPress") {

            } else if (it.event == "onChange") {

            }
        }
        return event
    }

    fun buildNovaPadding(padding: SDUIPadding ? ): NovaPadding {
        if (padding == null) {
            return NovaPadding()
        }
        return NovaPadding(top = padding.top, bottom = padding.bottom, start = padding.left, end = padding.right)
    }

}
