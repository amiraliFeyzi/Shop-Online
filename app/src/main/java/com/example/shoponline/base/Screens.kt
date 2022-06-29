package com.example.shoponline.base

import com.example.shoponline.utils.variable.*


sealed class Screens(val route:String){
    object HomeScreen:Screens(HOME_SCREEN)
    object CategoriesScreen:Screens(CATEGORIES_SCREEN)
    object SearchScreen:Screens(SEARCH_SCREEN)
    object ProfileScreen:Screens(PROFILE_SCREEN)
    object DetailCategoryScreen:Screens(DETAIL_CATEGORY_SCREEN)
}