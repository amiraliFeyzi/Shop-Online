package com.example.shoponline.model.datasource.product

import com.example.shoponline.model.apiservice.ApiService
import com.example.shoponline.model.dataclass.Product

class ProductRemoteDataSource(private val apiService: ApiService):ProductDataSource {

    override suspend fun getAmazingOffProduct(): List<Product> =
        apiService.getAmazingOffProduct()

    override suspend fun getNewProducts(): List<Product> =
        apiService.getNewProducts()
}