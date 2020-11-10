package com.siba.searchmvvmpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    private val _position: MutableLiveData<Int> = MutableLiveData()
    val position: LiveData<Int>
        get() = _position
    private val _tabItems: MutableLiveData<List<String>> = MutableLiveData()
    val tabItems: LiveData<List<String>>
        get() = _tabItems

    init {
        _tabItems.postValue(TAB_ITEMS)
    }

    fun selectPosition(position: Int) {
        _position.postValue(position)
    }

    companion object {
        private val TAB_ITEMS = listOf("Search Book", "Search Best Seller")
    }
}