package com.example.shoponline.model.repository.product.featureproduct

import com.example.shoponline.model.dataclass.OptionProduct
import com.example.shoponline.model.dataclass.PropertiesProduct
import com.example.shoponline.model.dataclass.ReviewProduct
import kotlinx.coroutines.flow.Flow

interface FeaturesProductRepository {
    suspend fun getOptionProduct(id:String):Flow<List<OptionProduct>>

    suspend fun getPropertiesProduct(id: String):Flow<List<PropertiesProduct>>

    suspend fun getReviewProduct(id: String):Flow<List<ReviewProduct>>
}