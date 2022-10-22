package com.example.shoponline.view.detailproduct

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.shoponline.base.BaseViewModel
import com.example.shoponline.model.dataclass.PropertiesProduct
import com.example.shoponline.model.repository.product.featureproduct.FeaturesProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertiesProductViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val featuresProductRepository: FeaturesProductRepository
):BaseViewModel() {

    private val _propertiesProductList = MutableStateFlow<List<PropertiesProduct>>(listOf())
    val propertiesProductList = _propertiesProductList.asStateFlow()

    private fun getProductId():String{
        return savedStateHandle.get<String>("id")!!
    }

    init {
        fetchPropertiesProduct()
    }

    private  fun fetchPropertiesProduct(){
        viewModelScope.launch(Dispatchers.IO) {
            featuresProductRepository.getPropertiesProduct(getProductId()).collectLatest {
                _propertiesProductList.value = it
            }
        }

    }
}