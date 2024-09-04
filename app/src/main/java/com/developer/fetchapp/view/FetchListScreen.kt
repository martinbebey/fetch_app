package com.developer.fetchapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
    modifier: Modifier = Modifier,
    listViewState: ListViewState
){
    Box(modifier = Modifier.fillMaxSize()){
        when{
            listViewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            listViewState.error != null -> {
                Text(text = "ERROR OCCURED WHILE FETCHING DATA")
            }

            else -> {
                LazyColumn(){
                    items(listViewState.itemList){
                            itemFromList -> FetchedListItem(item = itemFromList)
                    }
                }
            }
        }
    }
}