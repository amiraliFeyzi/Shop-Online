package com.example.shoponline.model.datasource.brand

import com.example.shoponline.model.dataclass.Brand

interface BrandDataSource {
    suspend fun getBrand():List<Brand>
}