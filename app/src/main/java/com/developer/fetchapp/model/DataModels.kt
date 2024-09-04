package com.developer.fetchapp.model

import android.os.Parcelable

data class Item(
    var id: String,
    var listId: String,
    var name: String
)

data class ListViewState(
    val loading: Boolean = true,
    val error: String? = null,
    val itemList: List<Item> = emptyList(),
)
