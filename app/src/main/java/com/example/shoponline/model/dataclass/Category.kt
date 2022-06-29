package com.example.shoponline.model.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: String,
    val link_img: String,
    val tittle: String
):Parcelable