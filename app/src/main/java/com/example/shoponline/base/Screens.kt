package com.example.shoponline.base

import com.example.shoponline.utils.variable.CATEGORIES_SCREEN
import com.example.shoponline.utils.variable.HOME_SCREEN
import com.example.shoponline.utils.variable.PROFILE_SCREEN
import com.example.shoponline.utils.variable.SEARCH_SCREEN


sealed class Screens(val route:String){
    object HomeScreen:Screens(HOME_SCREEN)
    object CategoriesScreen:Screens(CATEGORIES_SCREEN)
    object SearchScreen:Screens(SEARCH_SCREEN)
    object ProfileScreen:Screens(PROFILE_SCREEN)
}