package com.example.shoponline.model.repository.product

import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.model.datasource.product.ProductDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl (private val productRemoteDataSource:ProductDataSource):ProductRepository {
    override suspend fun getAmazingOffProduct(): Flow<List<Product>> {
        return flow {
            emit(productRemoteDataSource.getAmazingOffProduct())
        }
    }

    override suspend fun getNewProducts(): Flow<List<Product>> {
        return flow{
            emit(productRemoteDataSource.getNewProducts())
        }
    }
}