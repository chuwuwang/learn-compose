package com.ktx.compose.sdui

data class SDUIComponent(
    val id: String,
    val type: String,
    val style: SDUIStyle ? = null,
    val actions: List<SDUIAction> ? = null,

    val text: String ? = null,
    val alignment: String ? = null,
    val children: List<SDUIComponent> ? = null,
)

data class SDUIStyle(
    val width: Int = -1,
    val height: Int = -1,
    val minWidth: Int ? = null,
    val maxWidth: Int ? = null,
    val minHeight: Int ? = null,
    val maxHeight: Int ? = null,
    val padding: SDUIPadding ? = null,
    val borderRadius: Int ? = null,
    val backgroundColor: String ? = null,

    val font: String ? = null,
    val color: String ? = null,
    val textAlign: String ? = null,
    val lineLimit: Int ? = null,
)

data class SDUIAction(
    val event: String,
    val target: String ? = null,
)

data class SDUIPadding(
    val left: Int = 0,
    val top: Int = 0,
    val right: Int = 0,
    val bottom: Int = 0,
)