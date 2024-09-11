package com.developer.fetchapp.model

import com.developer.fetchapp.navigation.Screens

data class Item(
    var id: String,
    var listId: String,
    var name: String?
)

//data class ListViewState(
//    val loading: Boolean = true,
//    val error: String? = null,
//    val itemList: List<Item> = mutableListOf(),
//)

sealed interface ViewState {
    data object Loading: ViewState

    data class Error(
        val error: String
    ): ViewState

    data class Success(
        val itemList: List<Item>
    ): ViewState
}
