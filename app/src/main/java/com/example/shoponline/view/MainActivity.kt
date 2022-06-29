package com.example.shoponline.view

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shoponline.R
import com.example.shoponline.base.Screens
import com.example.shoponline.model.dataclass.BottomNavItem
import com.example.shoponline.model.dataclass.Category
import com.example.shoponline.ui.theme.ShopOnlineTheme
import com.example.shoponline.utils.variable.EXTRA_KEY_DATA
import com.example.shoponline.view.categories.CategoryScreen
import com.example.shoponline.view.detailcategory.ui.DetailCategoryScreen
import com.example.shoponline.view.home.ui.HomeScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopOnlineTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController){
                            navController.navigate(it.route)
                        }
                    }
                ) {
                    Theme()
                    Navigation(navController)

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

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route){
        composable(Screens.HomeScreen.route){
            HomeScreen(navController)
        }

        composable(Screens.CategoriesScreen.route){
            CategoryScreen()
        }

        composable(Screens.SearchScreen.route){
            Text(text = "Search" , textAlign = TextAlign.Center , fontSize = 24.sp ,
                color = Color.Black ,modifier =Modifier.fillMaxSize())

        }

        composable(Screens.ProfileScreen.route){
            Text(text = "Profile" , textAlign = TextAlign.Center , fontSize = 24.sp ,
                color = Color.Black ,  modifier =Modifier.fillMaxSize())

        }

        composable(Screens.DetailCategoryScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>(
                EXTRA_KEY_DATA)
            category?.let {
                DetailCategoryScreen(navController , category)

            }
        }



    }
}

@Composable
fun BottomBar(
    modifier:Modifier = Modifier,
    navController: NavController,
    onItemClick: (BottomNavItem)->Unit

) {

    val items = listOf(
        BottomNavItem(
            Screens.HomeScreen.route ,
            stringResource(id = R.string.home),
            R.drawable.ic_baseline_home_24
        ),
        BottomNavItem(
            Screens.CategoriesScreen.route ,
            stringResource(id = R.string.category),
            R.drawable.ic_baseline_view_list_24
        ),
        BottomNavItem(
            Screens.SearchScreen.route ,
            stringResource(id = R.string.search),
            R.drawable.ic_baseline_search_24
        ),
        BottomNavItem(
            Screens.ProfileScreen.route ,
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
            val selected  =item.route == backStackEntry.value?.destination?.route

            BottomNavigationItem(
                selected = selected  ,
                onClick = { onItemClick(item)} ,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Icon(painter = painterResource(id = item.icon),
                            contentDescription ="icon" )
                        if (selected){
                            Text(
                                text = item.label ,
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




