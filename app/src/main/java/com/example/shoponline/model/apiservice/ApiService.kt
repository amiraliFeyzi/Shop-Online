package com.example.shoponline.model.apiservice

import com.example.shoponline.model.dataclass.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getBanner.php")
    suspend fun getBanner():List<Banner>

    @GET("getCategory.php")
    suspend fun getCategoryHome():List<Category>

    @GET("getAllCategory.php")
    suspend fun getAllCategory():List<Category>

    @GET("getDetailCategory.php")
    suspend fun getDetailCategory(@Query("id")id:String):List<Category>

    @GET("getAmazingOfferProduct.php")
    suspend fun getAmazingOffProduct():List<Product>

    @GET("getSuggestionsBanner.php")
    suspend fun getSuggestionsBanners():List<Banner>

    @GET("getNewProducts.php")
    suspend fun getNewProducts():List<Product>

    @GET("getBrand.php")
    suspend fun getBrand():List<Brand>

    @GET("getPopularDetail.php")
    suspend fun getPopularDetailProduct(@Query("id")id:String):List<Product>

    @GET("getDetailNewProduct.php")
    suspend fun getDetailNewProduct(@Query("id")id:String):List<Product>

    @GET("getCategoryDetailProduct.php")
    suspend fun getCategoryDetailProduct(@Query("id")id:String):List<Product>

    @GET("getImageProduct.php")
    suspend fun getDetailImageProduct(@Query("id")id: String):List<ImageProduct>

    @GET("getSimilarProduct.php")
    suspend fun getSimilarProduct(@Query("category_id")categoryId:String):List<Product>

    @GET("getOptionProduct.php")
    suspend fun getOptionProduct(@Query("id")id:String):List<OptionProduct>

    @GET("getPropertiesProduct.php")
    suspend fun getPropertiesProduct(@Query("id")id:String):List<PropertiesProduct>

    @GET("getReviewProduct.php")
    suspend fun getReviewProduct(@Query("id")id:String):List<ReviewProduct>

    @GET("getCompareProduct.php")
    suspend fun getCompareProduct(@Query("category_id")categoryId:String):List<Product>





}