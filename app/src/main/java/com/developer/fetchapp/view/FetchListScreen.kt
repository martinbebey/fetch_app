package com.developer.fetchapp.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.developer.fetchapp.model.Item
import com.developer.fetchapp.model.ListViewState


@Composable
fun FetchListScreen(
    fetchedItemsList: List<Item>,
    listViewState: ListViewState,
    modifier: Modifier = Modifier
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