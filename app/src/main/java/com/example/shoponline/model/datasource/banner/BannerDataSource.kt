package com.example.shoponline.model.datasource.banner

import com.example.shoponline.model.dataclass.Banner

interface BannerDataSource {
    suspend fun getBanners():List<Banner>

    suspend fun getSuggestionsBanner():List<Banner>
}