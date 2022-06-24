package com.example.shoponline.model.apiservice

import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.model.dataclass.Banner
import com.example.shoponline.model.dataclass.Brand
import com.example.shoponline.model.dataclass.Category
import retrofit2.http.GET

interface ApiService {

    @GET("getBanner.php")
    suspend fun getBanner():List<Banner>

    @GET("getCategory.php")
    suspend fun getCategoryHome():List<Category>

    @GET("getAmazingOfferProduct.php")
    suspend fun getAmazingOffProduct():List<Product>

    @GET("getSuggestionsBanner.php")
    suspend fun getSuggestionsBanners():List<Banner>

    @GET("getNewProducts.php")
    suspend fun getNewProducts():List<Product>

    @GET("getBrand.php")
    suspend fun getBrand():List<Brand>
}