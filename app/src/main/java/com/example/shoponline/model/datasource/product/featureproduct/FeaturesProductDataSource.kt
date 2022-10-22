package com.example.shoponline.model.datasource.product.featureproduct

import com.example.shoponline.model.dataclass.OptionProduct
import com.example.shoponline.model.dataclass.PropertiesProduct
import com.example.shoponline.model.dataclass.ReviewProduct

interface FeaturesProductDataSource {
    suspend fun getOptionProduct(id:String):List<OptionProduct>

    suspend fun getPropertiesProduct(id: String):List<PropertiesProduct>

    suspend fun getReviewProduct(id: String):List<ReviewProduct>
}