package com.developer.fetchapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.fetchapp.model.Item
import com.developer.fetchapp.model.ListViewState
import com.developer.fetchapp.services.fetchService
import kotlinx.coroutines.launch
import kotlin.math.log

class FetchListScreenViewModel: ViewModel() {
    private val _listScreenViewState = mutableStateOf(ListViewState())
    val listViewState: State<ListViewState> = _listScreenViewState

    init {
        fetchList()
    }

    fun filterNullOrEmpty() {

        val filteredList: MutableList<Item> = _listScreenViewState.value.itemList.toMutableList()

        viewModelScope.launch {
            try {
                for(item in filteredList){
                    if (item.name.isNullOrEmpty()){
                        filteredList.remove(item)
                    }
                }
            }
            catch (exception: Exception){
                Log.d("mb-", "${exception.printStackTrace()}")
            }
        }

        _listScreenViewState.value = _listScreenViewState.value.copy(
            loading = false,
            error = null,
            itemList = filteredList
        )
    }

    private fun fetchList(){
        viewModelScope.launch {
            try {
                val response = fetchService.getListItems()

                response.sortBy { it.name }
                response.sortBy { it.listId }

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

                Log.d("mb-", "${exception.printStackTrace()}")
            }
        }
    }
}