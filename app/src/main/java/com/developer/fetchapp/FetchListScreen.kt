package com.developer.fetchapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun FetchListScreen(
    fetchedItemsList: List<Item>
){
    LazyColumn(){
        items(fetchedItemsList){
            itemFromList ->
            FetchedListItem(item = itemFromList)
        }
    }
}