package com.siba.searchmvvmpractice.repository

import com.siba.searchmvvmpractice.model.BookData
import com.siba.searchmvvmpractice.model.SearchBookData
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InterparkService {
    @GET("search.api")
    suspend fun requestSearchBook(
        @Query("key") key: String,
        @Query("query") query: String,
    ): Deferred<SearchBookData>

    @GET("bestSeller.api")
    suspend fun requestSearchBestSeller(
        @Query("key") key: String,
        @Query("categoryId") query: Int = 100,
        @Query("output") output: String = "json",
    ): Deferred<SearchBookData>
}