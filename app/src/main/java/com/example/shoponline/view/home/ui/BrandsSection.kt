package com.example.shoponline.view.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.R
import com.example.shoponline.model.dataclass.Brand
import com.example.shoponline.view.home.HomeViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Brand(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val brandList = viewModel.brandList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(end = 4.dp, start = 4.dp)
    ){
        Text(
            text = stringResource(id = R.string.popularBrand),
            color = Color.Black,
            fontSize = 12.sp
        )
        Spacer(
            modifier = Modifier.height(12.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            items(brandList.value.size){
                ItemBrand(brand = brandList.value[it])
            }
        }
    }
}

@Composable
fun ItemBrand(
    brand: Brand
) {
    Column(
        modifier =
        Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = brand.link_img,
            contentDescription = "brand",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = brand.name ,
            color = Color.Black,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}