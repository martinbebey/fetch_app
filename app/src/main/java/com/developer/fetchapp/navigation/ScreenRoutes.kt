package com.developer.fetchapp.navigation

/**
* keeps track of screen routes
 * @param route
* */
sealed class Screens(val route: String) {
    object FetchListScreen: Screens("fetch_list_screen")
}