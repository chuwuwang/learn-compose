package com.ktx.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.ktx.compose.ui.BaseCMPActivity
import com.ktx.compose.ui.widget.ModifierUtils
import com.ktx.compose.ui.widget.RwTopAppBar
import com.ktx.compose.view.component.TruncateText

class TruncateTextActivity : BaseCMPActivity() {

    @Composable
    override fun Screen() {
        Column {
            RwTopAppBar("显示全文效果") { finish() }

            TruncateText(
                fontSize = 16.sp,
                modifier = ModifierUtils.space_norm,
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        }
    }

}