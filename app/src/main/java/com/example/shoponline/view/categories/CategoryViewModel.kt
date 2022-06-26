package com.example.shoponline.view.categories

import androidx.lifecycle.viewModelScope
import com.example.shoponline.base.BaseViewModel
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.model.repository.category.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryViewModel @Inject constructor(private val categoryRepository: CategoryRepository):BaseViewModel() {
    private val _categoryList = MutableStateFlow<List<Category>>(listOf())
    val categoryList = _categoryList.asStateFlow()

    init {
        fetchAllCategory()
    }
    private fun fetchAllCategory(){
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.getAllCategory().collectLatest {
                _categoryList.value = it
            }

        }
    }

}