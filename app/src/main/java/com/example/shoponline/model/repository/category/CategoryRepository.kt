package com.example.shoponline.model.repository.category

import com.example.shoponline.model.dataclass.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategoryHome():Flow<List<Category>>

    suspend fun getAllCategory():Flow<List<Category>>
}