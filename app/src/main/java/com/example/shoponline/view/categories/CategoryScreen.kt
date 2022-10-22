package com.example.shoponline.view.categories

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.model.dataclass.Category

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val categoryList = viewModel.categoryList.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(start = 8.dp , end= 8.dp , top = 12.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),

    ){
        items(categoryList.value.size){
            ItemCategory(category = categoryList.value[it])
        }
    }
}

@Composable
fun ItemCategory(category: Category) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
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
                    .align(CenterVertically)
            )

            AsyncImage(
                model = category.link_img,
                contentDescription = "category",
                modifier = Modifier
                    .align(CenterVertically)
                    .size(60.dp),

            )
        }
    }
}
