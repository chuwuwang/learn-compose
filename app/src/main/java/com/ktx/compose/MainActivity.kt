package com.ktx.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ktx.compose.ui.theme.Dimens
import com.ktx.compose.ui.theme.KTXTheme
import com.ktx.compose.ui.widget.LightStatusBar

class MainActivity : ComponentActivity() {

    private val dataList = arrayListOf(
        Pair("Customize View", R.drawable.img_carousel_1),
        Pair("Cool Animation", R.drawable.img_carousel_2),
    )

    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { KTXTheme { Screen() } }
    }

    @Preview(device = "id:pixel_9_pro_xl")
    @Composable
    private fun Screen() {
        LightStatusBar()
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            verticalItemSpacing = Dimens.px_8,
            columns = StaggeredGridCells.Fixed(count = 2),
            contentPadding = PaddingValues(all = Dimens.px_16),
            horizontalArrangement = Arrangement.spacedBy(Dimens.px_8)
        ) {
            items(dataList) { item -> ItemView(item = item) }
        }
    }

    @Composable
    private fun ItemView(item: Pair<String, Int>) {
        val onClick = {

        }
        val modifier = Modifier.fillMaxWidth().clickable(onClick = onClick).height(300.dp)
        Card(modifier = modifier) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(modifier = Modifier.matchParentSize(), painter = painterResource(id = item.second), contentScale = ContentScale.Crop, contentDescription = "")

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                )
                Text(text = item.first)
            }
        }
    }

}