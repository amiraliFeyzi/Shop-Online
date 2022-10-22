package com.example.shoponline.view.detailproduct.ui.review

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shoponline.view.detailcategory.ui.Toolbar
import com.example.shoponline.view.detailproduct.ReviewProductViewModel

@Composable
fun ReviewProductScreen(
    navHostController: NavHostController,
    name:String,
    viewModel:ReviewProductViewModel = hiltViewModel()
) {
    val reviewProductList = viewModel.reviewProductList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        item {

            Toolbar(title = name, navHostController =navHostController )
            Spacer(modifier = Modifier.height(12.dp))

        }
        items(reviewProductList.value.size){
            Text(
                text = reviewProductList.value[0].header,
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp , end =12.dp , bottom = 20.dp)


            )
        }
        items(reviewProductList.value.size){
            Box(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            ){
                AsyncImage(
                    model = reviewProductList.value[it].link_img,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp).align(Alignment.Center)
                )
            }

        }

        items(reviewProductList.value.size){
            Text(
                text = reviewProductList.value[it].final_text,
                color = Color.Black ,
                modifier = Modifier.padding(start = 12.dp , end =12.dp , bottom = 64.dp)
            )
        }
    }
}