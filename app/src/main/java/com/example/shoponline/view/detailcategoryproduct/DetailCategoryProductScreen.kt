package com.example.shoponline.view.detailcategoryproduct

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shoponline.R
import com.example.shoponline.base.Screens
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.utils.functions.formatPrice
import com.example.shoponline.view.detailcategory.ui.Toolbar

@Composable
fun DetailCategoryProductScreen(
    navHostController: NavHostController,
    tittle:String,
    viewModel: DetailCategoryProductViewModel = hiltViewModel()
) {
    val listProduct = viewModel.listProduct.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(title = tittle, navHostController = navHostController)
        Spacer(modifier = Modifier.height(4.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(listProduct.value.size) {
                ItemDetailCategoryProduct(listProduct.value[it]){product ->
                    navHostController.navigate(Screens.DetailProduct.route+
                            "/${product.id}" +
                            "/${product.name}" +
                            "/${product.brand}" +
                            "/${product.category_id}" +
                            "/${product.value_off}" +
                            "/${product.price}" +
                            "/${product.offprice}" +
                            "/${product.category_id}"

                    )

                }
            }
        }
    }

}

@Composable
fun ItemDetailCategoryProduct(
     product: Product ,
     onProductClick : (Product) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onProductClick(product)
            }
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){

                AsyncImage(
                    model = product.link_img,
                    contentDescription = "productImg" ,
                    modifier  = Modifier.size(150.dp).padding(top = 8.dp)
                )

                Column {
                    Text(
                        text = product.name ,
                        color = Color.Black ,
                        fontSize = 12.sp ,
                        modifier = Modifier.padding(top = 12.dp)

                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.ic_baseline_shopping_cart_24
                            ),
                            contentDescription ="shopping" ,
                            tint = Color.Red
                        )

                        Text(
                            text= stringResource(id = R.string.availableInStock) ,
                            color = Color.Black ,
                            fontSize = 12.sp
                        )
                    }
                }




            }

            Text(
                text = "${formatPrice(product.price)}",
                color = Color.Red ,
                textAlign = TextAlign.End ,
                modifier = Modifier.padding(end= 8.dp).align(Alignment.End)
            )


        }

        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 12.dp, end = 12.dp)
                .background(Color.Gray)

        )


    }
}