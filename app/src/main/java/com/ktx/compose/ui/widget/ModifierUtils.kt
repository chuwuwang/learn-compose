package com.ktx.compose.ui.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.ktx.compose.ui.theme.Dimens

object ModifierUtils {

    val space_norm: Modifier
        get() = Modifier.padding(start = Dimens.px_16, top = Dimens.px_16, end = Dimens.px_16)

}