package com.ktx.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ktx.compose.extension.navigateTo
import com.ktx.compose.ui.BaseCMPActivity
import com.ktx.compose.ui.theme.Dimens
import com.ktx.compose.ui.theme.Fonts
import com.ktx.compose.ui.widget.RwTopAppBar
import com.ktx.compose.view.CustomizeViewActivity

class MainActivity : BaseCMPActivity() {

    private val dataList = arrayListOf(
        Pair("Customize View", R.drawable.img_carousel_1),
        Pair("Cool Animation", R.drawable.img_carousel_2),
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(device = "id:pixel_9_pro_xl")
    @Composable
    override fun Screen() {
        Column(modifier = Modifier.fillMaxSize()) {
            val text = stringResource(id = R.string.app_name)
            RwTopAppBar(text)

            LazyVerticalStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                verticalItemSpacing = Dimens.px_8,
                columns = StaggeredGridCells.Fixed(count = 2),
                contentPadding = PaddingValues(all = Dimens.px_16),
                horizontalArrangement = Arrangement.spacedBy(Dimens.px_8),
            ) {
                itemsIndexed(dataList) { index, item -> ItemView(item = item, index = index) }
            }
        }
    }

    @Composable
    private fun ItemView(item: Pair<String, Int>, index: Int) {
        val onClick = {
            if (index == 0) {
                navigateTo<CustomizeViewActivity>()
            }
        }
        val modifier = Modifier.fillMaxWidth().clickable(onClick = onClick).height(300.dp)
        Card(modifier = modifier) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(modifier = Modifier.matchParentSize(), painter = painterResource(id = item.second), contentScale = ContentScale.Crop, contentDescription = "")

                val color = Color.Black.copy(alpha = 0.3f)
                val modifier = Modifier.fillMaxSize().background(color)
                Box(modifier)

                val style = TextStyle(fontSize = Dimens.sp_18, fontFamily = Fonts.medium, color = Color.White)
                Text(text = item.first, style = style)
            }
        }
    }

}