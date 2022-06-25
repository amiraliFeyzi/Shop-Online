package com.example.shoponline.utils.functions

import android.text.SpannableString
import android.text.style.RelativeSizeSpan
import java.text.DecimalFormat

fun formatPricer(
    price:String,
    unitRelativeSizeFactor: Float = 0.7f
):SpannableString{
    val decimalFormat = DecimalFormat("###,###")
    val myPrice =  decimalFormat.format(Integer.valueOf(price))

    val currencyLabel = "تومان"
    val spannableString = SpannableString("$myPrice $currencyLabel")
    spannableString.setSpan(
        RelativeSizeSpan(unitRelativeSizeFactor),
        spannableString.indexOf(currencyLabel),
        spannableString.length,
        SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    return spannableString
}