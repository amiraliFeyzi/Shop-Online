package com.example.shoponline.view.detailcategoryproduct

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.shoponline.base.BaseViewModel
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.model.dataclass.Product
import com.example.shoponline.model.repository.product.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailCategoryProductViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val productRepository: ProductRepository
):BaseViewModel() {
    private val _listProduct = MutableStateFlow<List<Product>>(listOf())
    val listProduct = _listProduct.asStateFlow()

    init {
        fetchDetailCategoryProduct()
    }

    private fun getDetailCategory():String{
        return savedStateHandle.get<String>("id")!!
    }

    private fun fetchDetailCategoryProduct(){
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getCategoryDetailProduct(getDetailCategory()).collectLatest {
                _listProduct.value = it
            }
        }
    }
}