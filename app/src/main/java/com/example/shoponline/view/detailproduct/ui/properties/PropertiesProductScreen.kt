package com.example.shoponline.view.detailproduct.ui.properties

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.shoponline.model.dataclass.PropertiesProduct
import com.example.shoponline.view.detailcategory.ui.Toolbar
import com.example.shoponline.view.detailproduct.DetailProductViewModel
import com.example.shoponline.view.detailproduct.PropertiesProductViewModel

@Composable
fun PropertiesProductScreen(
     navHostController: NavHostController,
     name:String ,
     viewModel:PropertiesProductViewModel = hiltViewModel()
) {

    val propertiesProductList = viewModel.propertiesProductList.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ){
        item{
            Toolbar(title = "مشخصات فنی", navHostController =navHostController )
            Spacer(modifier = Modifier.height(12.dp))
        }

        item{
            Box(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 24.dp)
            ){
                Text(
                    text = name ,
                    color = Color.Black ,
                    fontWeight = FontWeight.Bold ,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }
        items(propertiesProductList.value.size){
            ItemPropertiesProduct(propertiesProduct = propertiesProductList.value[it])
        }

    }
}

@Composable
fun ItemPropertiesProduct(
    propertiesProduct: PropertiesProduct
) {
    Column {
        Text(
            text = propertiesProduct.description ,
            modifier = Modifier.padding(start = 8.dp),
            color =  Color.Black ,

        )
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(1.dp)
                .padding(horizontal = 12.dp)
                .background(Color.Gray)
        )
    }
}