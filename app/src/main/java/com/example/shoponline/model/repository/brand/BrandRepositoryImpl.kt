package com.example.shoponline.model.repository.brand

import com.example.shoponline.model.dataclass.Brand
import com.example.shoponline.model.datasource.brand.BrandDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BrandRepositoryImpl(private val brandRemoteDataSource:BrandDataSource):BrandRepository {
    override suspend fun getBrand(): Flow<List<Brand>> {
        return flow{
            emit(brandRemoteDataSource.getBrand())
        }
    }
}