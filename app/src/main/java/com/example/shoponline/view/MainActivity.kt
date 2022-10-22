package com.example.shoponline.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shoponline.R
import com.example.shoponline.base.Screens
import com.example.shoponline.model.dataclass.BottomNavItem
import com.example.shoponline.ui.theme.ShopOnlineTheme
import com.example.shoponline.view.categories.CategoryScreen
import com.example.shoponline.view.detailcategory.ui.DetailCategoryScreen
import com.example.shoponline.view.detailcategoryproduct.DetailCategoryProductScreen
import com.example.shoponline.view.detailproduct.ui.BottomSheetDetailProduct
import com.example.shoponline.view.detailproduct.ui.DetailProductScreen
import com.example.shoponline.view.detailproduct.ui.chart.ChartScreen
import com.example.shoponline.view.detailproduct.ui.compare.CompareProductScreen
import com.example.shoponline.view.detailproduct.ui.properties.PropertiesProductScreen
import com.example.shoponline.view.detailproduct.ui.review.ReviewProductScreen
import com.example.shoponline.view.home.ui.HomeScreen
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterialNavigationApi::class)
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopOnlineTheme {
                val bottomSheetNavigator = rememberBottomSheetNavigator()
                val navController = rememberNavController(bottomSheetNavigator)

                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController) {
                            navController.navigate(it.route)
                        }
                    },
                ){
                    Theme()
                    Navigation(navController = navController , bottomSheetNavigator)
                }


            }
        }
    }
}

@Composable
fun Theme() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFFE40404)

        )
    }
}

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun Navigation(navController: NavHostController , bottomSheetNavigator: BottomSheetNavigator) {
    com.google.accompanist.navigation.material.ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {
        NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
            composable(Screens.HomeScreen.route) {
                HomeScreen(navController)
            }

            composable(Screens.CategoriesScreen.route) {
                CategoryScreen()
            }

            composable(Screens.SearchScreen.route) {
                Text(
                    text = "Search", textAlign = TextAlign.Center, fontSize = 24.sp,
                    color = Color.Black, modifier = Modifier.fillMaxSize()
                )

            }

            composable(Screens.ProfileScreen.route) {
                Text(
                    text = "Profile", textAlign = TextAlign.Center, fontSize = 24.sp,
                    color = Color.Black, modifier = Modifier.fillMaxSize()
                )

            }

            composable(Screens.DetailCategoryScreen.route + "/{id}" + "/{tittle}",
                arguments = listOf(
                    navArgument("id") {
                        type = NavType.StringType
                    },
                    navArgument("tittle") {
                        type = NavType.StringType
                        nullable = false
                    }
                )
            ) {
                val tittle = it.arguments?.getString("tittle")

                DetailCategoryScreen(navController, tittle!!)


            }

            composable(Screens.DetailCategoryProduct.route + "/{id}" + "/{tittle}",
                arguments = listOf(
                    navArgument("id") {
                        type = NavType.StringType
                        nullable = false
                    },
                    navArgument("tittle") {
                        type = NavType.StringType
                        nullable = false
                    }
                )
            ) {
                val tittle = it.arguments?.getString("tittle")
                DetailCategoryProductScreen(navController, tittle!!)

            }

            composable(Screens.DetailProduct.route +
                    "/{id}" +
                    "/{name}" +
                    "/{brand}" +
                    "/{category_id}" +
                    "/{value_off}" +
                    "/{price}" +
                    "/{off_price}" +
                    "/{categoryId}"
                ,
                arguments = listOf(
                    navArgument("id") {
                        type = NavType.StringType
                    },
                    navArgument("name") {
                        type = NavType.StringType
                    },
                    navArgument("brand") {
                        type = NavType.StringType
                    },
                    navArgument("category_id") {
                        type = NavType.StringType
                    },
                    navArgument("value_off") {
                        type = NavType.StringType
                    },
                    navArgument("price") {
                        type = NavType.StringType
                    },
                    navArgument("off_price") {
                        type = NavType.StringType
                    },
                    navArgument("categoryId"){
                        type = NavType.StringType
                    }
                )) {
                val id = it.arguments?.getString("id")
                val name = it.arguments?.getString("name")
                val brand = it.arguments?.getString("brand")
                val valueOff = it.arguments?.getString("value_off")
                val price = it.arguments?.getString("price")
                val offPrice = it.arguments?.getString("off_price")
                val categoryId = it.arguments?.getString("categoryId")


                DetailProductScreen(navHostController = navController, id!!, name!!, brand!!,valueOff!! , price!! , offPrice!! , categoryId!!)

            }

            composable(Screens.PropertiesProduct.route + "/{id}" + "/{name}",
                arguments = listOf(
                    navArgument("id") {
                        NavType.StringType
                        nullable = false
                    },
                    navArgument("name") {
                        NavType.StringType
                        nullable = false
                    }
                )) {
                val name = it.arguments?.getString("name")
                PropertiesProductScreen(navController, name!!)
            }

            composable(Screens.ReviewProduct.route + "/{id}" + "/{name}",
                arguments = listOf(
                    navArgument("id") {
                        NavType.StringType
                        nullable = false
                    },
                    navArgument("name") {
                        NavType.StringType
                        nullable = false
                    }
                )) {
                val name = it.arguments?.getString("name")
                ReviewProductScreen(navController, name!!)
            }

            bottomSheet(Screens.BottomSheetDetailProduct.route + "/{categoryId}" ,
            arguments = listOf(
                navArgument(
                    "categoryId"
                ){
                    type=NavType.StringType
                    nullable = false
                }
            )){
                val categoryId = it.arguments?.getString("categoryId")
                BottomSheetDetailProduct(navController ,categoryId!!)
            }

            composable(Screens.ChartScreen.route){
                ChartScreen()
            }

            composable(Screens.CompareProductScreen.route + "/{categoryId}" ,
            arguments = listOf(
                navArgument("categoryId"){
                    type = NavType.StringType
                    nullable =false
                }
            )){
                val categoryId = it.arguments?.getString("categoryId")
                CompareProductScreen(navController , categoryId!! )
            }

            composable(Screens.MainCompareProductScreen.route){

            }




        }


    }


}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit

) {

    val items = listOf(
        BottomNavItem(
            Screens.HomeScreen.route,
            stringResource(id = R.string.home),
            R.drawable.ic_baseline_home_24
        ),
        BottomNavItem(
            Screens.CategoriesScreen.route,
            stringResource(id = R.string.category),
            R.drawable.ic_baseline_view_list_24
        ),
        BottomNavItem(
            Screens.SearchScreen.route,
            stringResource(id = R.string.search),
            R.drawable.ic_baseline_search_24
        ),
        BottomNavItem(
            Screens.ProfileScreen.route,
            stringResource(id = R.string.profile),
            R.drawable.ic_baseline_account_circle_24
        )
    )
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Red,
        elevation = 5.dp
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = "icon"
                        )
                        if (selected) {
                            Text(
                                text = item.label,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                },

                )

        }

    }
}