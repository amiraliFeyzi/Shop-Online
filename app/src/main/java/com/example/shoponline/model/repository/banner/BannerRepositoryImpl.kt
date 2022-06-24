package com.example.shoponline.model.repository.banner

import com.example.shoponline.model.dataclass.Banner
import com.example.shoponline.model.datasource.banner.BannerDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BannerRepositoryImpl (private val bannerRemoteDataSource: BannerDataSource):BannerRepository  {
    override suspend fun getBanners(): Flow<List<Banner>> {
        return flow {
            emit(bannerRemoteDataSource.getBanners())
        }
    }

    override suspend fun getSuggestionsBanner(): Flow<List<Banner>> {
        return flow{
            emit(bannerRemoteDataSource.getSuggestionsBanner())
        }
    }
}