package com.example.shoponline.model.repository.banner

import com.example.shoponline.model.dataclass.Banner
import kotlinx.coroutines.flow.Flow

interface BannerRepository {
    suspend fun getBanners():Flow<List<Banner>>

    suspend fun getSuggestionsBanner():Flow<List<Banner>>
}