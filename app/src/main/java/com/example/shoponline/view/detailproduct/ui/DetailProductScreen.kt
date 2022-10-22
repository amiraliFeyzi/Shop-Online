package com.example.shoponline.view.detailproduct.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.shoponline.R
import com.example.shoponline.base.Screens

@Composable
fun DetailProductScreen(
    navHostController: NavHostController,
    id: String,
    name: String,
    brand: String,
    valueOff:String,
    price:String,
    offPrice:String,
    categoryId:String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())


    ) {
        ToolBarDetailProductScreen(navHostController = navHostController) {
            navHostController.navigate(Screens.BottomSheetDetailProduct.route+ "/${categoryId}")
        }
        Spacer(modifier = Modifier.height(8.dp))
        ImageProductSection()
        Spacer(modifier = Modifier.height(12.dp))
        InformationProduct(name = name, brand = brand)
        Spacer(modifier = Modifier.height(36.dp))
        ReceivePoint()
        Spacer(modifier = Modifier.height(8.dp))
        SimilarProductSection(navHostController)
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color(0xFFF3EFEF))
        )
        ProductOptionSection()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.height(12.dp))

        PropertiesText {
            navHostController.navigate(Screens.PropertiesProduct.route + "/${id}" + "/${name}")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 8.dp, end = 8.dp)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.height(12.dp))

        ReviewProductText {
            navHostController.navigate(Screens.ReviewProduct.route + "/${id}" + "/${name}" )
        }
        CartSection(price = price, valueOff = valueOff, offPrice = offPrice)
    }


}


@Composable
fun ToolBarDetailProductScreen(navHostController: NavHostController, onMoreClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Red)
    ) {

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
                contentDescription = "More",
                modifier = Modifier
                    .padding(end = 12.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                contentDescription = "More",
                modifier = Modifier
                    .padding(end = 8.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
                contentDescription = "More",
                modifier = Modifier
                    .padding(end = 4.dp)
                    .clickable {
                        onMoreClick()
                    }
            )
        }


        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_24),
            contentDescription = "More",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 4.dp)
                .clickable {
                    navHostController.popBackStack()
                }
        )
    }

}


@Composable
fun InformationProduct(name: String, brand: String) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "اسم محصول: $name",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = " برند محصول: $brand",
                color = Color(0xFF044A87),
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(4.dp)
                    .padding(start = 12.dp)

            )
        }

    }

}

@Composable
fun ReceivePoint() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFFF3EFEF))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 24.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .align(Alignment.Center)
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.you_buy_this_product),
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .alpha(0.5f)
                        .padding(start = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.spacedBy(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.point),
                        contentDescription = "point",
                        modifier = Modifier.width(30.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.receive25Point),
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                }

            }
        }
    }


}

@Composable
fun PropertiesText(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.propertiesProduct),
            color = Color.Black,
            modifier = Modifier
                .padding(start = 8.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_left_24),
            contentDescription = null,
            modifier = Modifier.size(20.dp)

        )
    }
}

@Composable
fun ReviewProductText(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 64.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.reviewProduct),
            color = Color.Black,
            modifier = Modifier
                .padding(start = 8.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_left_24),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
    }
}