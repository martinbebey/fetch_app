package com.developer.fetchapp.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.developer.fetchapp.model.Item
import com.developer.fetchapp.model.ListViewState


@Composable
fun FetchListScreen(
    fetchedItemsList: List<Item>,
    listViewState: ListViewState
){
    when{
        listViewState.loading -> {
            CircularProgressIndicator()
        }

        listViewState.error != null -> {
            Text(text = "ERROR OCCURED WHILE LIST DATA}")
        }

        else -> {
            LazyColumn(){
                items(fetchedItemsList){
                    itemFromList -> FetchedListItem(item = itemFromList)
                }
            }
        }
    }
}