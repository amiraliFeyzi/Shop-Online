package com.example.shoponline.di

import com.example.shoponline.model.apiservice.ApiService
import com.example.shoponline.model.datasource.banner.BannerRemoteDataSource
import com.example.shoponline.model.datasource.brand.BrandRemoteDataSource
import com.example.shoponline.model.datasource.category.CategoryRemoteDataSource
import com.example.shoponline.model.datasource.product.ProductRemoteDataSource
import com.example.shoponline.model.datasource.product.featureproduct.FeatureProductRemoteDataSource
import com.example.shoponline.model.repository.banner.BannerRepository
import com.example.shoponline.model.repository.banner.BannerRepositoryImpl
import com.example.shoponline.model.repository.brand.BrandRepository
import com.example.shoponline.model.repository.brand.BrandRepositoryImpl
import com.example.shoponline.model.repository.category.CategoryRepository
import com.example.shoponline.model.repository.category.CategoryRepositoryImpl
import com.example.shoponline.model.repository.product.ProductRepository
import com.example.shoponline.model.repository.product.ProductRepositoryImpl
import com.example.shoponline.model.repository.product.featureproduct.FeaturesProductRepository
import com.example.shoponline.model.repository.product.featureproduct.FeaturesProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBannerRepository(apiService: ApiService):BannerRepository{
        return BannerRepositoryImpl(BannerRemoteDataSource(apiService))
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(apiService: ApiService):CategoryRepository{
        return CategoryRepositoryImpl(CategoryRemoteDataSource(apiService))
    }

    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService):ProductRepository{
        return ProductRepositoryImpl(ProductRemoteDataSource(apiService))
    }

    @Provides
    @Singleton
    fun provideBrandRepository(apiService: ApiService):BrandRepository{
        return BrandRepositoryImpl(BrandRemoteDataSource(apiService))
    }

    @Provides
    @Singleton
    fun provideFeaturesProductRepository(apiService: ApiService):FeaturesProductRepository{
        return FeaturesProductRepositoryImpl(FeatureProductRemoteDataSource(apiService))
    }
}