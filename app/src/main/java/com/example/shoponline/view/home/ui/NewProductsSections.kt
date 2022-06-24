package com.example.shoponline.view.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.R
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.view.home.HomeViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewProducts(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val newProducts = viewModel.newProductList.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(800.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(id = R.string.newProducts),
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp)

            )

            Text(
                text = stringResource(id = R.string.showAll),
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(3)
        ){
            items(newProducts.value.size){
                ItemNewProducts(product = newProducts.value[it])
            }
        }

    }
}

@Composable
fun ItemNewProducts(product: Product) {
    Column(
        modifier = Modifier
            .scale(1.01f)
            .border(
                width = 1.dp, Color.Gray
            )

    ) {
        AsyncImage(
            model = product.link_img,
            contentDescription = "amazingProduct" ,
            modifier = Modifier
                .aspectRatio(1f)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Inside
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.name,
            maxLines =  2 ,
            color = Color.Black ,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(start = 8.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start ,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "${product.price}تومان ",
            color = Color.Red ,
            modifier = Modifier
                .padding(end = 8.dp, bottom = 8.dp)
                .wrapContentSize()
                .align(Alignment.End),
            fontWeight = FontWeight.Bold ,
            textAlign = TextAlign.End,
            fontSize = 12.sp


        )

    }
}