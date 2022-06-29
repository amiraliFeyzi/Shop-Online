package com.example.shoponline.view.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()
        ) {
        ToolBar()
        Spacer(modifier = Modifier.height(20.dp))
        Slider()
        Spacer(modifier = Modifier.height(36.dp))
        CategoryList(navHostController)
        Spacer(modifier = Modifier.height(36.dp))
        AmazingOfferProduct()
        Spacer(modifier = Modifier.height(36.dp))
        SuggestionsBanner()
        Spacer(modifier = Modifier.height(36.dp))
        NewWatch()
        Spacer(modifier = Modifier.height(36.dp))
        NewProducts()
        Spacer(modifier = Modifier.height(36.dp))
        Brand()
    }
}




