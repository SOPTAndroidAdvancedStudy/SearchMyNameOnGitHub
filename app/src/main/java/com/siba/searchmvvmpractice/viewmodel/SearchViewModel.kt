package com.siba.searchmvvmpractice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siba.searchmvvmpractice.model.BookData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {
    private val _position: MutableLiveData<Int> = MutableLiveData()
    val position: LiveData<Int>
        get() = _position
    private val _tabItems: MutableLiveData<List<String>> = MutableLiveData()
    val tabItems: LiveData<List<String>>
        get() = _tabItems
    private val _dummyData: MutableLiveData<MutableList<BookData>> = MutableLiveData()
    val dummyData: LiveData<MutableList<BookData>>
        get() = _dummyData

    init {
        _tabItems.postValue(TAB_ITEMS)
        viewModelScope.launch {
            dummuyAdd()
        }
    }

    fun selectPosition(position: Int) {
        _position.postValue(position)
    }

    private suspend fun dummuyAdd() {
        withContext(Dispatchers.Main) {
            val tempData = mutableListOf<BookData>()
            tempData.apply {
                add(
                    BookData(
                        img_book = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg/894px-Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg",
                        txt_title = "되찾은 시간",
                        txt_author = "박성민"
                    )
                )
                add(
                    BookData(
                        img_book = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg/894px-Gutenberg_Bible%2C_Lenox_Copy%2C_New_York_Public_Library%2C_2009._Pic_01.jpg",
                        txt_title = "되찾은 시간",
                        txt_author = "박성민"
                    )
                )
                add(
                    BookData(
                        img_book = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        txt_title = "되찾은 시간",
                        txt_author = "박성민"
                    )
                )
                add(
                    BookData(
                        img_book = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        txt_title = "되찾은 시간",
                        txt_author = "박성민"
                    )
                )
                add(
                    BookData(
                        img_book = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        txt_title = "되찾은 시간",
                        txt_author = "박성민"
                    )
                )
                add(
                    BookData(
                        img_book = "https://bimage.interpark.com/goods_image/6/2/1/4/261696214h.jpg",
                        txt_title = "되찾은 시간",
                        txt_author = "박성민"
                    )
                )
            }
            _dummyData.setValue(tempData)
        }
    }

    companion object {
        private val TAB_ITEMS = listOf("Search Book", "Search Best Seller")
    }
}