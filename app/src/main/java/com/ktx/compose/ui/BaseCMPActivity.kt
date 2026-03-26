package com.ktx.compose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.ktx.compose.ui.theme.KTXTheme
import com.ktx.compose.ui.widget.LightStatusBar

abstract class BaseCMPActivity : ComponentActivity() {

    @Composable
    abstract fun Screen()

    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { KTXTheme { Content() } }
    }

    @Composable
    private fun Content() {
        LightStatusBar()
        Screen()
    }

}