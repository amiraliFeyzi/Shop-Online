package com.example.shoponline.view.detailcategory.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shoponline.base.Screens
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.utils.variable.EXTRA_KEY_DATA
import com.example.shoponline.view.categories.ItemCategory
import com.example.shoponline.view.detailcategory.DetailCategoryViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailCategory(
    navHostController: NavHostController,
    viewModel:DetailCategoryViewModel = hiltViewModel()
) {
    val detailCategoryList = viewModel.detailCategoryList.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(start = 8.dp , end= 8.dp)
            .height(300.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
        items(detailCategoryList.value.size){
            ItemDetailCategory(navHostController,category = detailCategoryList.value[it])
        }
    }
}


@Composable
fun ItemDetailCategory(navHostController: NavHostController,category: Category) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable {
                navHostController.navigate(Screens.DetailCategoryProduct.route+"/${category.id}"+"/${category.tittle}")
            }
        ,
        elevation = 8.dp,
        backgroundColor = Color.White

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = category.tittle,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically)
            )

            AsyncImage(
                model = category.link_img,
                contentDescription = "category",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(60.dp),

                )
        }
    }
}