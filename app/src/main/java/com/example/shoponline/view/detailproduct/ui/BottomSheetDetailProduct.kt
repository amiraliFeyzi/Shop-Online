package com.example.shoponline.view.detailproduct.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.shoponline.R
import com.example.shoponline.base.Screens

@Composable
fun BottomSheetDetailProduct(
    navHostController: NavHostController ,
    categoryId:String
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navHostController.navigate(Screens.CompareProductScreen.route + "/${categoryId}")
                }

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_compare_24),
                contentDescription = null,
                modifier  = Modifier.padding(start = 8.dp , top = 4.dp)
            )
            Text(
                text = stringResource(id = R.string.productComparison),
                modifier = Modifier.padding(start = 8.dp),
                color = Color.Black,

                )


        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(horizontal = 12.dp)
                .background(Color.Gray)
        )
        Row(modifier = Modifier.fillMaxWidth().clickable {
            navHostController.navigate(Screens.ChartScreen.route)
        }) {

            Image(
                painter = painterResource(id = R.drawable.ic_baseline_insert_chart_outlined_24),
                contentDescription = null,
                modifier  = Modifier.padding(start = 8.dp , top = 4.dp)

            )

            Text(
                text = stringResource(id = R.string.priceChart),
                modifier = Modifier.padding(start = 8.dp),
                color = Color.Black,

                )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(horizontal = 12.dp)
                .background(Color.Gray)
        )

        Row(modifier = Modifier.fillMaxWidth().clickable {
            val intent  = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_SUBJECT , "اپلیکیشن فروشگاهی")
            intent.putExtra(Intent.EXTRA_TEXT , "اشتراک گذاری")
            context.startActivity(Intent.createChooser(intent ,"اپلیکیشن فروشگاهی" ))

        }) {

            Image(
                painter = painterResource(id = R.drawable.ic_baseline_share_24),
                contentDescription = null,
                modifier  = Modifier.padding(start = 8.dp , top = 4.dp)

            )

            Text(
                text = stringResource(id = R.string.share),
                modifier = Modifier.padding(start = 8.dp),
                color = Color.Black,

                )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(horizontal = 12.dp)
                .background(Color.Gray)
        )
    }
}