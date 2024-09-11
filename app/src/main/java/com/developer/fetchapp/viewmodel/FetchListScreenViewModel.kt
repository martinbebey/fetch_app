package com.developer.fetchapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.fetchapp.model.ViewState
import com.developer.fetchapp.services.fetchService
import kotlinx.coroutines.launch

/**
 * This is the viewmodel for the list screen
 **/
class FetchListScreenViewModel: ViewModel() {
    private val _listScreenViewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val listViewState: State<ViewState> = _listScreenViewState

    init {
        fetchList()
    }

    /**
     * Launches the api service for fetching the remote data list in a coroutine (non-blocking asynchronous execution).
     * All items from the api response with a null or blank name are discarded.
     * The remaining items are sorted first by listId and then by name.
     * The resulting list is grouped by listId.
     **/
    private fun fetchList(){
        viewModelScope.launch {
            try {
                val response = fetchService.getListItems()

                response.removeIf{it.name.isNullOrBlank()}
                response.sortBy { it.name }
                response.sortBy { it.listId }

                _listScreenViewState.value = ViewState.Success(response)
            }
            catch (exception: Exception){
                _listScreenViewState.value = ViewState.Error("error loading data")
            }
        }
    }
}