package com.example.shoponline.view.detailproduct.ui.compare

import androidx.lifecycle.viewModelScope
import com.example.shoponline.base.BaseViewModel
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
class CompareProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
):BaseViewModel() {
    private val _compareListProduct= MutableStateFlow<List<Product>>(listOf())
    val compareListProduct = _compareListProduct.asStateFlow()



    fun getCompareProduct(category_id:String){
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.getCompareProduct(category_id).collectLatest {
                _compareListProduct.value = it
            }
        }
    }


}