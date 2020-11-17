package com.siba.searchmvvmpractice.repository

import android.util.Log
import com.siba.searchmvvmpractice.local.dao.SearchTermDao
import com.siba.searchmvvmpractice.local.database.SearchTermDatabase
import com.siba.searchmvvmpractice.local.entity.RecentSearchTerm
import com.siba.searchmvvmpractice.remote.RetrofitService
import com.siba.searchmvvmpractice.remote.api.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchRepository(
    private val retrofitService: RetrofitService,
    private val searchTermDao: SearchTermDao
) {
    suspend fun fetchUser(userName : String) = retrofitService.getUsers(userName)

    suspend fun insertKeyword(recentSearchTerm: RecentSearchTerm){
        searchTermDao.insertKeyword(recentSearchTerm)
    }

    suspend fun getAllKeyword(){
        searchTermDao.getAllKeyword()
    }
}