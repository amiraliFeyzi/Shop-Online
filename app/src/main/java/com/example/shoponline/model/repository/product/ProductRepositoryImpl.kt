package com.example.shoponline.model.repository.product

import com.example.shoponline.model.dataclass.ImageProduct
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

    override suspend fun getPopularDetailProduct(id: String): Flow<List<Product>> {
        return flow{
            emit(productRemoteDataSource.getPopularDetailProduct(id))
        }
    }

    override suspend fun getDetailNewProduct(id: String): Flow<List<Product>> {
        return flow{
            emit(productRemoteDataSource.getDetailNewProduct(id))
        }
    }

    override suspend fun getCategoryDetailProduct(id: String): Flow<List<Product>> {
        return flow{
            emit(productRemoteDataSource.getCategoryDetailProduct(id))
        }

    }

    override suspend fun getDetailImageProduct(id: String): Flow<List<ImageProduct>> {
        return flow{
            emit(productRemoteDataSource.getDetailImageProduct(id))
        }
    }

    override suspend fun getSimilarProduct(categoryId: String): Flow<List<Product>> {
        return flow{
            emit(productRemoteDataSource.getSimilarProduct(categoryId))
        }
    }

    override suspend fun getCompareProduct(categoryId: String): Flow<List<Product>> {
        return flow{
            emit(productRemoteDataSource.getCompareProduct(categoryId))
        }
    }
}