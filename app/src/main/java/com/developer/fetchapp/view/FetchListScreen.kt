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
import androidx.compose.ui.res.stringResource
import com.developer.fetchapp.R
import com.developer.fetchapp.model.ListViewState
import com.developer.fetchapp.ui.theme.fetchErrorColour

/**
 * This controls what is displayed on the list screen.
 * A loading indicator is shown while the data is being fetched.
 * An error is shown to the user if the fetching operation fails.
 * Otherwise, if all goes well, then the data is shown
 *
 * @param modifier the composable modifier
 * @param listViewState the state of the fetching operation
 **/
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
                Text(text = stringResource(id = R.string.list_screen_error_text), color = fetchErrorColour)
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