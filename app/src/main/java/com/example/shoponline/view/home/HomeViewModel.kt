package com.example.shoponline.view.home

import androidx.lifecycle.viewModelScope
import com.example.shoponline.base.BaseViewModel
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.model.dataclass.Banner
import com.example.shoponline.model.dataclass.Brand
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.model.repository.banner.BannerRepository
import com.example.shoponline.model.repository.brand.BrandRepository
import com.example.shoponline.model.repository.category.CategoryRepository
import com.example.shoponline.model.repository.product.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bannerRepository: BannerRepository ,
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository,
    private val brandRepository: BrandRepository) :BaseViewModel() {

    private val _bannersList = MutableStateFlow<List<Banner>>(listOf())
    val bannersList = _bannersList.asStateFlow()

    private val _categoryList = MutableStateFlow<List<Category>>(listOf())
    val categoryList = _categoryList.asStateFlow()

    private val _amazingOffProduct = MutableStateFlow<List<Product>>(listOf())
    val amazingOffProduct = _amazingOffProduct.asStateFlow()

    private val  _suggestionsBannerList = MutableStateFlow<List<Banner>>(listOf())
    val suggestionsBannerList = _suggestionsBannerList.asStateFlow()

    private val _newProductList = MutableStateFlow<List<Product>>(listOf())
    val newProductList = _newProductList.asStateFlow()

    private val _brandList = MutableStateFlow<List<Brand>>(listOf())
    val brandList = _brandList.asStateFlow()


    init {
        callRequest()
    }
    private fun callRequest(){
        viewModelScope.launch(Dispatchers.IO) {
            async { fetchBanner() }
            async { fetchCategory() }
            async { fetchAmazingOffProduct() }
            async { fetchSuggestionsBanner() }
            async { fetchNewProducts() }
            async { fetchBrand() }
        }
    }

    private suspend fun fetchBanner(){
        bannerRepository.getBanners().collectLatest {
            _bannersList.value = it
        }
    }

    private suspend fun fetchCategory(){
        categoryRepository.getCategoryHome().collectLatest {
            _categoryList.value = it
        }
    }

    private suspend fun fetchAmazingOffProduct(){
        productRepository.getAmazingOffProduct().collectLatest {
            _amazingOffProduct.value = it
        }
    }

    private suspend fun fetchSuggestionsBanner(){
        bannerRepository.getSuggestionsBanner().collectLatest {
            _suggestionsBannerList.value = it
        }
    }

    private suspend fun fetchNewProducts(){
        productRepository.getNewProducts().collectLatest {
            _newProductList.value = it
        }
    }

    private suspend fun fetchBrand(){
        brandRepository.getBrand().collectLatest {
            _brandList.value = it
        }
    }

}