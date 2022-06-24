package com.example.shoponline.model.repository.brand

import com.example.shoponline.model.dataclass.Brand
import kotlinx.coroutines.flow.Flow

interface BrandRepository {
    suspend fun getBrand():Flow<List<Brand>>
}