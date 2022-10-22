package com.example.shoponline.model.repository.product.featureproduct

import com.example.shoponline.model.dataclass.OptionProduct
import com.example.shoponline.model.dataclass.PropertiesProduct
import com.example.shoponline.model.dataclass.ReviewProduct
import com.example.shoponline.model.datasource.product.featureproduct.FeaturesProductDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FeaturesProductRepositoryImpl (private val featuresProductRemoteDataSource:FeaturesProductDataSource):FeaturesProductRepository {
    override suspend fun getOptionProduct(id: String): Flow<List<OptionProduct>> {
        return flow{
            emit(featuresProductRemoteDataSource.getOptionProduct(id))
        }
    }

    override suspend fun getPropertiesProduct(id: String): Flow<List<PropertiesProduct>> {
        return flow{
            emit(featuresProductRemoteDataSource.getPropertiesProduct(id))
        }
    }

    override suspend fun getReviewProduct(id: String): Flow<List<ReviewProduct>> {
        return flow{
            emit(featuresProductRemoteDataSource.getReviewProduct(id))
        }
    }
}