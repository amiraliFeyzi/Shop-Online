package com.example.shoponline.view.detailproduct

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.shoponline.base.BaseViewModel
import com.example.shoponline.model.dataclass.*
import com.example.shoponline.model.repository.product.ProductRepository
import com.example.shoponline.model.repository.product.featureproduct.FeaturesProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val productRepository: ProductRepository,
    private val featuresProductRepository: FeaturesProductRepository):BaseViewModel() {

    private val _imageListProduct = MutableStateFlow<List<ImageProduct>>(listOf())
    val imageListProduct = _imageListProduct.asStateFlow()

    private val _similarProduct = MutableStateFlow<List<Product>>(listOf())
    val similarProduct = _similarProduct.asStateFlow()

    private val _featuresProductList = MutableStateFlow<List<OptionProduct>>(listOf())
    val featuresProductList = _featuresProductList.asStateFlow()


    private fun getProductId():String{
        return savedStateHandle.get<String>("id")!!
    }

    private fun getProductCategoryId():String{
        return savedStateHandle.get<String>("category_id")!!
    }

    init {
        callRequests()
    }

    private fun callRequests(){
        viewModelScope.launch(Dispatchers.IO) {
            async { fetchDetailImageProduct()  }
            async { fetchSimilarProduct() }
            async { fetchOptionProduct() }

        }
    }


    private suspend fun fetchDetailImageProduct(){
        productRepository.getDetailImageProduct(getProductId()).collectLatest {
            _imageListProduct.value = it
        }
    }

    private suspend fun fetchSimilarProduct(){
        productRepository.getSimilarProduct(getProductCategoryId()).collectLatest {
            _similarProduct.value = it
        }
    }

    private suspend fun fetchOptionProduct(){
        featuresProductRepository.getOptionProduct(getProductId()).collectLatest {
            _featuresProductList.value = it
        }
    }


}