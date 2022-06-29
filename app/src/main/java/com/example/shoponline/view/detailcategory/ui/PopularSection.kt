package com.example.shoponline.view.detailcategory.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shoponline.R
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.utils.functions.formatPricer
import com.example.shoponline.view.detailcategory.DetailCategoryViewModel

@Composable
fun PopularProductSection(
    viewModel : DetailCategoryViewModel  = hiltViewModel()
) {
    val popularProductDetail = viewModel.popularDetailProduct.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.popularProducts),
            color= Color.Black ,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold ,
            modifier = Modifier.padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(800.dp) ,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            items(popularProductDetail.value.size){
                ItemPopularProduct(product = popularProductDetail.value[it])
            }
        }


    }
}

@Composable
fun ItemPopularProduct(
    product: Product
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.specialOffer),
            color = Color.Red,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 12.dp, end = 12.dp)
                .background(Color.Red)

        )
        Spacer(modifier = Modifier.height(12.dp))
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            val (productImage , productName , availableIcon  , availableText  , productPrice , productValueOff , productOff) = createRefs()

            AsyncImage(
                model = product.link_img,
                contentDescription = "productImage",
                modifier = Modifier
                    .size(150.dp)
                    .constrainAs(productImage) {
                        start.linkTo(parent.start, 16.dp)
                        top.linkTo(parent.top, 24.dp)
                    }
            )

            Text(
                text = product.name,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .constrainAs(productName){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end , 16.dp)
                    start.linkTo(productImage.end , 24.dp)
                },
                fontSize = 12.sp

            )

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
                contentDescription = "shopping" ,
                tint = Color.Red,
                modifier = Modifier.constrainAs(availableIcon){
                    start.linkTo(productImage.end , 8.dp)
                    top.linkTo(productName.bottom , 30.dp)
                }

            )

            Text(
                text = stringResource(id = R.string.availableInStock),
                color = Color.Red,
                modifier = Modifier.constrainAs(availableText){
                    start.linkTo(availableIcon.end , 4.dp)
                    top.linkTo(availableIcon.top)
                    bottom.linkTo(availableIcon.bottom)
                }
            )

            Text(
                text = "%${product.value_off}" ,
                color = Color.White ,
                modifier = Modifier
                    .background(Color.Red)
                    .padding(top = 2.dp, bottom = 1.dp, start = 6.dp, end = 6.dp)
                    .constrainAs(productValueOff) {
                        start.linkTo(productImage.end, 8.dp)
                        bottom.linkTo(productImage.bottom, 20.dp)
                    },
                fontSize = 12.sp
            )

            Text(
                text = "${formatPricer(product.offprice.toString())}",
                color = Color(0xFF7CB342),
                modifier = Modifier
                    .constrainAs(productOff){
                        end.linkTo(parent.end , 16.dp)
                        top.linkTo(productValueOff.top)
                        bottom.linkTo(productValueOff.bottom)
                    }
            )

            Text(
                text= "${formatPricer(product.price)}" ,
                color = Color.Red ,
                style = TextStyle(textDecoration = TextDecoration.LineThrough),
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(productPrice){
                        top.linkTo(productOff.bottom , 4.dp)
                        end.linkTo(productOff.end)
                    }


                )


        }

    }
}

