package com.example.shoponline.model.datasource.brand

import com.example.shoponline.model.apiservice.ApiService
import com.example.shoponline.model.dataclass.Brand

class BrandRemoteDataSource(private val apiService: ApiService):BrandDataSource {
    override suspend fun getBrand(): List<Brand> =
        apiService.getBrand()

}