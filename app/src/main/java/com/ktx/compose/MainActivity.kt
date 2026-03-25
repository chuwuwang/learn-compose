package com.ktx.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ktx.compose.ui.theme.KTXTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { KTXTheme { Screen() } }
    }

    @Preview(device = "id:pixel_9_pro_xl")
    @Composable
    private fun Screen() {
        Text("Hello!")
    }


}