package com.ktx.compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ktx.compose.ui.BaseCMPActivity
import com.ktx.compose.ui.widget.ModifierUtils
import com.ktx.compose.ui.widget.RwTopAppBar
import com.ktx.compose.view.component.AnimatedStripeProgressBar

class AnimatedStripeProgressBarActivity : BaseCMPActivity() {

    @Composable
    override fun Screen() {
        Column {
            RwTopAppBar("条纹进度条") { finish() }

            AnimatedStripeProgressBar(modifier = ModifierUtils.space_norm, progress = 0.65f)
        }
    }

}