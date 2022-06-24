package com.example.shoponline.view.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.view.home.HomeViewModel

@Composable
fun CategoryList(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val categoryList= viewModel.categoryList.collectAsState()


    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentPadding = PaddingValues(start= 16.dp , end = 16.dp)
    ){
        items(categoryList.value.size){
            ItemCategory(category = categoryList.value[it])
        }
    }

}


@Composable
fun ItemCategory(category: Category) {
    Column(
        modifier = Modifier
            .wrapContentSize() ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            border = BorderStroke(1.dp , Color.Gray),
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.CenterHorizontally),
            shape = CircleShape ,
            elevation = 5.dp ,

            ) {
            AsyncImage(model = category.link_img, contentDescription = "category" ,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = category.tittle,
            fontSize = 12.sp,
            color  = Color.Black,
            modifier = Modifier
                .padding( end = 16.dp),
            textAlign = TextAlign.Center
        )
    }


}