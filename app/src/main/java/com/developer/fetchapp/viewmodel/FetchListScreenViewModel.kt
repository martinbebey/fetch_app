package com.developer.fetchapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.fetchapp.model.ListViewState
import com.developer.fetchapp.services.fetchService
import kotlinx.coroutines.launch

class FetchListScreenViewModel: ViewModel() {
    private val _listScreenViewState = mutableStateOf(ListViewState())
    val listViewState: State<ListViewState> = _listScreenViewState

    init {
        fetchList()
    }

    private fun fetchList(){
        viewModelScope.launch {
            try {
                val response = fetchService.getListItems()
                _listScreenViewState.value = _listScreenViewState.value.copy(
                    loading = false,
                    error = null,
                    itemList = response
                )
            }
            catch (exception: Exception){
                _listScreenViewState.value = _listScreenViewState.value.copy(
                    loading = false,
                    error = "Error fetching list ${exception.message}"
                )

                exception.printStackTrace()
            }
        }
    }
}