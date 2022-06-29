package com.example.shoponline.view.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.model.dataclass.Banner
import com.example.shoponline.view.home.HomeViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.shoponline.R

@Composable
fun ToolBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Red)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
            contentDescription ="logoShop",
            modifier =Modifier.align(Alignment.CenterEnd).padding(end = 8.dp)
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Slider(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val bannersList =  viewModel.bannersList.collectAsState()

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        HorizontalPager(
            count = bannersList.value.size  ,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp) ,
            verticalAlignment = Alignment.Top
        ) {

            ItemBanner(banner = bannersList.value[it])
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            , contentAlignment = Alignment.Center){
            HorizontalPagerIndicator(
                pagerState = pagerState ,
                activeColor = Color.Red ,
                inactiveColor = Color.Gray ,
            )
        }

    }

}

@Composable
fun ItemBanner(
    banner: Banner
) {
    AsyncImage(
        model = banner.link_img,
        contentDescription = "banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuggestionsBanner(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val suggestionBannerList = viewModel.suggestionsBannerList.collectAsState()
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ){
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            content ={
                items(suggestionBannerList.value.size){
                    ItemBanner(banner = suggestionBannerList.value[it])
                }
            },
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)

        )
    }

}
