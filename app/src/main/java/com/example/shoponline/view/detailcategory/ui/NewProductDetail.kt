package com.example.shoponline.view.detailcategory.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.R
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.utils.functions.formatPricer
import com.example.shoponline.view.detailcategory.DetailCategoryViewModel

@Composable
fun NewProductDetailCategory(
    viewModel:DetailCategoryViewModel = hiltViewModel()
) {
    val detailNewProduct = viewModel.detailNewProduct.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.newProductsExist),
            color  = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold ,
            modifier = Modifier.padding(start = 8.dp)

        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color(0xFF040A2E))
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color(0xFF040A2E)),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(12.dp)
            ){
                item{
                    FirstItemDetailNewProduct()
                }

                items(detailNewProduct.value.size){
                    ItemNewDetailProduct(product = detailNewProduct.value[it])

                }
            }
        }
    }
}

@Composable
fun FirstItemDetailNewProduct() {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
            .padding(start = 8.dp)
            .background(Color(0xFF040A2E))
            .clip(RoundedCornerShape(10.dp))) {

        AsyncImage(
            model = "https://cdn.pngsumo.com/digital-png-1-png-image-digital-asset-png-1203_1022.png",
            contentDescription = "imazing_image")

        Spacer(modifier = Modifier.height(50.dp))


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = stringResource(id = R.string.amazing),
            color = Color.White,
            maxLines = 2,
            fontWeight = FontWeight.Bold
        )

    }





}


@Composable
fun ItemNewDetailProduct(
    product: Product
) {
    Column(
        modifier = Modifier
            .height(300.dp)
            .width(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)

    ) {
        AsyncImage(
            model = product.link_img,
            contentDescription = "amazingProduct" ,
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
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
                .padding(start = 4.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start ,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(8.dp))



        Text(
            text = "${formatPricer(product.price)}" ,
            fontWeight = FontWeight.Bold ,
            color = Color.Red,
            modifier = Modifier
                .padding(end = 8.dp, top = 12.dp)
                .align(Alignment.End),
            fontSize = 12.sp
        )


    }
}

