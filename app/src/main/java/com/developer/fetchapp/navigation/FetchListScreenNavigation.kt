package com.developer.fetchapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.developer.fetchapp.view.FetchListScreen
import com.developer.fetchapp.viewmodel.FetchListScreenViewModel

/**
 * This controls the navigation for the app
 **/
@Composable
fun FetchListAppNavigation(navController: NavHostController){
    val fetchScreenViewModel: FetchListScreenViewModel = viewModel()
    val viewState by fetchScreenViewModel.listViewState

    NavHost(navController = navController, startDestination = Screens.FetchListScreen.route){
        composable(route = Screens.FetchListScreen.route){
            FetchListScreen(listViewState = viewState)
        }
    }
}