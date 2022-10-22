package com.example.shoponline.view.detailproduct.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoponline.R
import com.example.shoponline.model.dataclass.OptionProduct
import com.example.shoponline.view.detailproduct.DetailProductViewModel

@Composable
fun ProductOptionSection(
    viewModel:DetailProductViewModel = hiltViewModel()
) {
    val optionProductList = viewModel.featuresProductList.collectAsState()
    Column(
        modifier = Modifier.padding(bottom = 32.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = stringResource(id = R.string.productFeatures),
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
           
        )
        
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) ,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(optionProductList.value.size){
                ItemOptionProduct(optionProduct =optionProductList.value[it] )

            }
        }
    }
}

@Composable
fun ItemOptionProduct(
    optionProduct: OptionProduct
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_brightness_1_24),
            contentDescription = null ,
            tint = Color.Red,
            modifier = Modifier.width(14.dp).padding(start = 8.dp).align(CenterVertically)
        )

        Text(
            text = optionProduct.description ,
            color = Color.Black,
            modifier = Modifier.align(CenterVertically)

        )
    }
}