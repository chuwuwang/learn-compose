package com.ktx.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ktx.compose.ui.BaseCMPActivity
import com.ktx.compose.ui.theme.Dimens
import com.ktx.compose.ui.widget.RwButton
import com.ktx.compose.ui.widget.RwTopAppBar

class CustomizeViewActivity : BaseCMPActivity() {

    @Preview
    @Composable
    override fun Screen() {
        Column {
            RwTopAppBar("Customize View") { finish() }

            RwButton(
                Modifier.padding(start = Dimens.px_16, top = Dimens.px_16, end = Dimens.px_16),
                "打字机效果"
            ) {

            }

        }
    }

}