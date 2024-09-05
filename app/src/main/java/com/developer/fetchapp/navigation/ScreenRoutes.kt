package com.developer.fetchapp.navigation

/**
* keeps track of screen routes.
* Sealed class can be extended in the future if more screens are needed
**/
sealed class Screens(val route: String) {
    object FetchListScreen: Screens("fetch_list_screen")
}