package com.example.shoponline.view.detailproduct.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.shoponline.R
import com.example.shoponline.utils.functions.formatPrice

@Composable
fun CartSection(
    price:String,
    valueOff:String,
    offPrice:String,
) {

    val numberOfCounter = remember{
        mutableStateOf(0)
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 64.dp)

    ) {
        val (cartBtn , counter,priceCons,valueOfCons , offPriceCons) = createRefs()
        Button(
            onClick = {
                     numberOfCounter.value += 1
            } ,
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(4.dp))
                .padding(start = 8.dp)
                .constrainAs(cartBtn) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF83FF00) ,
            contentColor =  Color(0xFF83FF00))

        ) {
            Text(
                text = stringResource(id = R.string.addToCart),
                color = Color.White,
                fontWeight = FontWeight.Bold

            )
        }

        Button(onClick = { /*TODO*/ } ,
         modifier = Modifier
             .wrapContentSize()
             .clip(RoundedCornerShape(4.dp))
             .constrainAs(counter) {
                 start.linkTo(cartBtn.end, 8.dp)
                 top.linkTo(cartBtn.top)
                 bottom.linkTo(cartBtn.bottom)
             },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red ,
                contentColor =  Color.Red)
        ) {
            Text(
                text = numberOfCounter.value.toString() ,
                color = Color.White,

            )
        }

        Text(
            text = "%${valueOff}",
            modifier = Modifier
                .background(Color.Red)
                .padding(top = 2.dp, bottom = 1.dp, start = 6.dp, end = 6.dp)
                .constrainAs(valueOfCons) {
                    end.linkTo(parent.end, 8.dp)
                    top.linkTo(cartBtn.top)
                },
            color = Color.White,
            fontSize = 12.sp
        )

        Text(
            text = "${formatPrice(offPrice)}" ,
            modifier = Modifier
                .constrainAs(offPriceCons){
                    end.linkTo(valueOfCons.start , 8.dp)
                    top.linkTo(valueOfCons.top)
                    bottom.linkTo(valueOfCons.bottom)
                } ,
            color = Color(0xFF7CB342),
            fontSize = 12.sp


        )

        Text(
            text = "${formatPrice(price)}" ,
            style = TextStyle(textDecoration = TextDecoration.LineThrough),
            color = Color.Red ,
            modifier = Modifier
                .constrainAs(priceCons){
                    end.linkTo(parent.end , 8.dp)
                    top.linkTo(valueOfCons.bottom , 4.dp)
                },
            fontSize = 12.sp


        )
    }
    
}