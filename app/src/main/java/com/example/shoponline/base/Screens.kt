package com.example.shoponline.base

import com.example.shoponline.utils.variable.*


sealed class Screens(val route:String){
    object HomeScreen:Screens(HOME_SCREEN)
    object CategoriesScreen:Screens(CATEGORIES_SCREEN)
    object SearchScreen:Screens(SEARCH_SCREEN)
    object ProfileScreen:Screens(PROFILE_SCREEN)
    object DetailCategoryScreen:Screens(DETAIL_CATEGORY_SCREEN)
    object DetailCategoryProduct:Screens(DETAIL_CATEGORY_PRODUCT_SCREEN)
    object DetailProduct:Screens(DETAIL_PRODUCT_SCREEN)
    object PropertiesProduct:Screens(PROPERTIES_PRODUCT_SCREEN)
    object ReviewProduct:Screens(REVIEW_PRODUCT_SCREEN)
    object BottomSheetDetailProduct:Screens(BOTTOM_SHEET_DETAIL_PRODUCT)
    object ChartScreen:Screens(CHART_SCREEN)
    object CompareProductScreen:Screens(COMPARE_PRODUCT_SCREEN)
    object MainCompareProductScreen:Screens(MAIN_COMPARE_PRODUCT_SCREEN)


}