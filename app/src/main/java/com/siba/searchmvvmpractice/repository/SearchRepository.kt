package com.siba.searchmvvmpractice.repository

import com.siba.searchmvvmpractice.model.SearchBookData
import com.siba.searchmvvmpractice.singleton.KeyPreference

class SearchRepository() {
    private val interparkService: InterparkService = InterparkServiceImpl.getService()

    suspend fun searchBookService(
        query: String
    ): SearchBookData {
        return interparkService.requestSearchBook(
            KeyPreference.getKey(),
            query
        ).await()
    }

    suspend fun searchBestSellerService(
        img_book: String,
        categoryId: Int = 100,
        output: String = "json"
    ): SearchBookData {
        return interparkService.requestSearchBestSeller(
            img_book,
            categoryId,
            output
        ).await()
    }
}