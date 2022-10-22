package com.example.shoponline.view.detailcategory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.shoponline.base.BaseViewModel
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.model.dataclass.Product
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
class DetailCategoryViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val categoryRepository: CategoryRepository,
    private val productRepository: ProductRepository):BaseViewModel() {

    private val _detailCategoryList = MutableStateFlow<List<Category>>(listOf())
    val detailCategoryList = _detailCategoryList.asStateFlow()

    private val _popularDetailProduct = MutableStateFlow<List<Product>>(listOf())
    val popularDetailProduct = _popularDetailProduct.asStateFlow()

    private val _detailNewProduct = MutableStateFlow<List<Product>>(listOf())
    val detailNewProduct = _detailNewProduct.asStateFlow()

    private fun getCategoryId():String{
        return savedStateHandle.get<String>("id")!!
    }

    init {
        callRequest()
    }

    //cal all request in this screen
    private fun callRequest(){
        viewModelScope.launch(Dispatchers.IO) {
            async { fetchDetailCategory() }
            async { fetchPopularDetailProduct() }
            async { fetchDetailNewProduct() }
        }
    }

    private suspend fun fetchDetailCategory(){
        categoryRepository.getDetailCategory(getCategoryId()).collectLatest {
                _detailCategoryList.value = it
        }
    }


    private suspend fun fetchPopularDetailProduct(){
        productRepository.getPopularDetailProduct(getCategoryId()).collectLatest {
            _popularDetailProduct.value = it
        }
    }

    private suspend fun fetchDetailNewProduct(){
        productRepository.getDetailNewProduct(getCategoryId()).collectLatest {
            _detailNewProduct.value = it
        }
    }

}






