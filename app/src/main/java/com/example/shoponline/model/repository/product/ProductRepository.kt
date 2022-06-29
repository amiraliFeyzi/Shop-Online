package com.example.shoponline.model.repository.product

import com.example.shoponline.model.dataclass.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getAmazingOffProduct(): Flow<List<Product>>

    suspend fun getNewProducts():Flow<List<Product>>

    suspend fun getPopularDetailProduct(id:String):Flow<List<Product>>

    suspend fun getDetailNewProduct(id:String):Flow<List<Product>>


}
