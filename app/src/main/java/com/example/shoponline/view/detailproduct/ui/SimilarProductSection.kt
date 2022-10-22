package com.example.shoponline.view.detailproduct.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shoponline.R
import com.example.shoponline.base.Screens
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.utils.functions.formatPrice
import com.example.shoponline.view.detailproduct.DetailProductViewModel

@Composable
fun SimilarProductSection(
    navHostController:NavHostController ,
    viewModel:DetailProductViewModel = hiltViewModel()
) {
    val similarProductList = viewModel.similarProduct.collectAsState()

    Column(

    ) {
        Text(
            text = stringResource(id = R.string.similarProduct),
            color = Color.Black ,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight() ,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(similarProductList.value.size){
                ItemSimilarProduct(similarProductList.value[it]){product->
                    navHostController.navigate(Screens.DetailProduct.route+"/${product.id}" + "/${product.name}" + "/${product.brand}" + "/${product.category_id}")

                }

            }
        }

    }
}

@Composable
fun ItemSimilarProduct(
    product: Product,
    onProductClick :(Product) -> Unit

) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .clickable {
            onProductClick(product)
        }
        .padding(bottom = 12.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(Color.Gray)
                .align(Alignment.CenterEnd)

        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) {


            AsyncImage(
                model = product.link_img,
                contentDescription = "productImage",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.name ,
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(end = 4.dp)


            )

            Text(
                text = "${formatPrice(product.price)}" ,
                color = Color.Red ,
                modifier = Modifier
                    .align(End)
                    .padding(end = 8.dp)
            )


        }
    }

}