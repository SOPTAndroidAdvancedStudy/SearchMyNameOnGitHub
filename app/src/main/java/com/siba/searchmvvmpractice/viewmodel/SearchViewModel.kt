package com.siba.searchmvvmpractice.viewmodel

import androidx.lifecycle.*
import com.siba.searchmvvmpractice.model.BookData
import com.siba.searchmvvmpractice.model.SearchBookData
import com.siba.searchmvvmpractice.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel: ViewModel() {
    private val _position: MutableLiveData<Int> = MutableLiveData()
    val position: LiveData<Int>
        get() = _position
    private val _tabItems: MutableLiveData<List<String>> = MutableLiveData()
    val tabItems: LiveData<List<String>>
        get() = _tabItems
    private val _dummyData: MutableLiveData<MutableList<BookData>> = MutableLiveData()
    val dummyData: LiveData<MutableList<BookData>>
        get() = _dummyData
    private val _searchBookData: MutableLiveData<SearchBookData> = MutableLiveData()
    val searchBookData: LiveData<SearchBookData>
        get() = _searchBookData

    init {
        _tabItems.postValue(TAB_ITEMS)
//        viewModelScope.launch {
//            dummyAdd()
//        }
    }

    fun selectPosition(position: Int) {
        _position.postValue(position)
    }

    private suspend fun dummyAdd() {
        withContext(Dispatchers.Main) {
            val tempData = mutableListOf<BookData>()
            tempData.apply {
                add(
                    BookData(
                        coverSmallUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg/894px-Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg",
                        title = "되찾은 시간",
                        author = "박성민"
                    )
                )
                add(
                    BookData(
                        coverSmallUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg/894px-Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg",
                        title = "되찾은 시간",
                        author = "박성민"
                    )
                )
                add(
                    BookData(
                        coverSmallUrl = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        title = "되찾은 시간",
                        author = "박성민"
                    )
                )
                add(
                    BookData(
                        coverSmallUrl = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        title = "되찾은 시간",
                        author = "박성민"
                    )
                )
                add(
                    BookData(
                        coverSmallUrl = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        title = "되찾은 시간",
                        author = "박성민"
                    )
                )
                add(
                    BookData(
                        coverSmallUrl = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        title = "되찾은 시간",
                        author = "박성민"
                    )
                )
            }
            _dummyData.setValue(tempData)
        }
    }

    fun searchBook(bookName: String) {
        viewModelScope.launch {
            val bookDatas = SearchRepository().searchBookService(bookName)
            _searchBookData.value = bookDatas
        }
    }

    companion object {
        private val TAB_ITEMS = listOf("Search Book", "Search Best Seller")
    }
}