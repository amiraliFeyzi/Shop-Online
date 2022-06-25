package com.example.shoponline.view.home.ui

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.R
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.utils.functions.formatPricer
import com.example.shoponline.view.home.HomeViewModel

@Composable
fun AmazingOfferProduct(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val amazingOfferProduct = viewModel.amazingOffProduct.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = stringResource(id = R.string.endOfAmazingProduct),
                color = Color.Black ,
                fontSize = 12.sp

            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Red)
        ){
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.Red),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(12.dp)
            ){
                item {
                    FirstItemAmazingOffer()
                }
                items(amazingOfferProduct.value.size){
                    ItemAmazingOfferProduct(amazingOfferProduct.value[it])
                }
            }


        }
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = stringResource(id = R.string.resumeAmazingProduct),
            color= Color.Red,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )


    }


}


@Composable
fun FirstItemAmazingOffer() {
    Column(
        modifier = Modifier
            .width(150.dp)
            .height(300.dp)
            .padding(start = 8.dp)
            .background(Color.Red)
            .clip(RoundedCornerShape(10.dp))) {

        AsyncImage(
            model = "https://www.pngkit.com/png/full/28-283565_discount-tag-png.png",
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
fun ItemAmazingOfferProduct(
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "%${product.value_off}" ,
                fontWeight = FontWeight.Bold ,
                textAlign = TextAlign.Start ,
                color = Color.White ,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .background(Color.Red)
                    .padding(top = 2.dp, bottom = 1.dp, start = 6.dp, end = 6.dp),
                fontSize = 12.sp

            )

            Text(
                text = "${formatPricer(product.offprice.toString())}" ,
                fontWeight = FontWeight.Bold ,
                textAlign = TextAlign.End ,
                color = Color(0xFF7CB342),
                modifier = Modifier.padding(end = 8.dp),
                fontSize = 12.sp


            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${formatPricer(product.price)}",
            color = Color.Red ,
            modifier = Modifier
                .padding(end = 8.dp)
                .wrapContentSize()
                .align(Alignment.End),
            fontWeight = FontWeight.Bold ,
            textAlign = TextAlign.End,
            style = TextStyle(textDecoration = TextDecoration.LineThrough),
            fontSize = 12.sp


        )

    }
}