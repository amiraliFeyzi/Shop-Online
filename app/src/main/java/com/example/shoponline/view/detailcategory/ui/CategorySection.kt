package com.example.shoponline.view.detailcategory.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.view.categories.ItemCategory
import com.example.shoponline.view.detailcategory.DetailCategoryViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailCategory(
    category: Category,
    viewModel:DetailCategoryViewModel = hiltViewModel()
) {
    viewModel.callRequest(category)
    val detailCategoryList = viewModel.detailCategoryList.collectAsState()
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(start = 8.dp , end= 8.dp)
            .height(300.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
        items(detailCategoryList.value.size){
            ItemCategory(category = detailCategoryList.value[it])
        }
    }
}