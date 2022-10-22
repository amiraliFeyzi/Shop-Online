package com.example.shoponline.view.detailproduct.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.view.detailproduct.DetailProductViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageProductSection(viewModel:DetailProductViewModel = hiltViewModel()) {

    val imageListProduct = viewModel.imageListProduct.collectAsState()
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        HorizontalPager(
            count = imageListProduct.value.size ,
            state = pagerState ,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ){
            AsyncImage(
                model = imageListProduct.value[it].link_img,
                contentDescription = "image"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            HorizontalPagerIndicator(
                pagerState = pagerState ,
                activeColor = Color.Red ,
                inactiveColor = Color.Gray ,
            )
        }
    }

}