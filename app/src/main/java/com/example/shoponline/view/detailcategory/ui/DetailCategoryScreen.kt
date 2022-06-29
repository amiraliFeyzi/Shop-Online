package com.example.shoponline.view.detailcategory.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shoponline.R
import com.example.shoponline.model.dataclass.Category

@Composable
fun DetailCategoryScreen(navHostController: NavHostController ,category: Category) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Toolbar(title = category.tittle , navHostController)
        DetailCategory(category)
        Spacer(modifier = Modifier.height(36.dp))
        NewProductDetailCategory()
        Spacer(modifier = Modifier.height(36.dp))
        PopularProductSection()

    }
}
@Composable
fun Toolbar(
    title:String,
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Red)
    ){
        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.White ,
            modifier  = Modifier.align(Alignment.Center)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_24),
            contentDescription = "back",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 8.dp)
                .clickable {
                    navHostController.popBackStack()
                }
        )
    }
}

