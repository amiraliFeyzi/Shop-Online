package com.example.shoponline.model.repository.category

import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.model.datasource.category.CategoryDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryRepositoryImpl (private val categoryRemoteDataSource: CategoryDataSource):CategoryRepository {
    override suspend fun getCategoryHome(): Flow<List<Category>> {
        return flow{
            emit(categoryRemoteDataSource.getCategoryHome())
        }
    }

    override suspend fun getAllCategory(): Flow<List<Category>> {
        return flow{
            emit(categoryRemoteDataSource.getAllCategory())
        }
    }
}