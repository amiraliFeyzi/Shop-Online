package com.example.shoponline.model.datasource.product.featureproduct

import com.example.shoponline.model.apiservice.ApiService
import com.example.shoponline.model.dataclass.OptionProduct
import com.example.shoponline.model.dataclass.PropertiesProduct
import com.example.shoponline.model.dataclass.ReviewProduct

class FeatureProductRemoteDataSource (private val apiService: ApiService):FeaturesProductDataSource {
    override suspend fun getOptionProduct(id: String): List<OptionProduct> =
        apiService.getOptionProduct(id)

    override suspend fun getPropertiesProduct(id: String): List<PropertiesProduct> =
        apiService.getPropertiesProduct(id)

    override suspend fun getReviewProduct(id: String): List<ReviewProduct> =
        apiService.getReviewProduct(id)
}