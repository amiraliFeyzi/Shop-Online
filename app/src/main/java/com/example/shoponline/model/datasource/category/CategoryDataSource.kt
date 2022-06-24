package com.example.shoponline.model.datasource.category

import com.example.shoponline.model.dataclass.Category

interface CategoryDataSource {
    suspend fun getCategoryHome():List<Category>
}