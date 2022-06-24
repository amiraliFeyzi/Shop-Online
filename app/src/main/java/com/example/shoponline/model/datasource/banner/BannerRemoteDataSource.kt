package com.example.shoponline.model.datasource.banner

import com.example.shoponline.model.apiservice.ApiService
import com.example.shoponline.model.dataclass.Banner

class BannerRemoteDataSource(private val apiService: ApiService):BannerDataSource {
    override suspend fun getBanners(): List<Banner>
        = apiService.getBanner()

    override suspend fun getSuggestionsBanner(): List<Banner> =
        apiService.getSuggestionsBanners()
}