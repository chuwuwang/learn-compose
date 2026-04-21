package com.ktx.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ktx.compose.extension.navigateTo
import com.ktx.compose.ui.BaseCMPActivity
import com.ktx.compose.ui.widget.ModifierUtils
import com.ktx.compose.ui.widget.RwButton
import com.ktx.compose.ui.widget.RwTopAppBar

class CustomizeViewActivity : BaseCMPActivity() {

    @Preview
    @Composable
    override fun Screen() {
        Column {
            RwTopAppBar("Customize View") { finish() }

            RwButton(ModifierUtils.space_norm, text = "打字机效果") {
                navigateTo<TypewriterTextActivity>()
            }

            RwButton(ModifierUtils.space_norm, text = "显示全文效果") {
                navigateTo<TruncateTextActivity>()
            }

        }

    }

}