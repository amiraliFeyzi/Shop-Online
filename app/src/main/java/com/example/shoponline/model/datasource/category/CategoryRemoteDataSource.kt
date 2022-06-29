package com.example.shoponline.model.datasource.category

import com.example.shoponline.model.apiservice.ApiService
import com.example.shoponline.model.dataclass.Category

class CategoryRemoteDataSource (private val apiService: ApiService):CategoryDataSource {
    override suspend fun getCategoryHome(): List<Category> =
        apiService.getCategoryHome()

    override suspend fun getAllCategory(): List<Category> =
        apiService.getAllCategory()

    override suspend fun getDetailCategory(id: String): List<Category> =
        apiService.getDetailCategory(id)

}