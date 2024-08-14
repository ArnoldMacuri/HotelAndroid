package com.arnold.cursocompose.ui.home

import android.content.ClipData.Item
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arnold.cursocompose.domain.usecase.HomeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val homeUseCase: HomeUseCase): ViewModel() {
    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    fun loadFeaturedItems(){
        viewModelScope.launch {
            val fetchedItems = homeUseCase.getFeaturedItems()
            _items.value = fetchedItems
        }
    }
}