package com.siba.searchmvvmpractice.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siba.searchmvvmpractice.local.entity.RecentSearchTerm
import com.siba.searchmvvmpractice.model.GithubUserData
import com.siba.searchmvvmpractice.model.ReposData
import com.siba.searchmvvmpractice.model.RetrofitData
import com.siba.searchmvvmpractice.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(
        private val repository: SearchRepository
) : ViewModel(){

    private val _userName = MutableLiveData<String>()
    val userName : MutableLiveData<String>
        get() = _userName

    private val _githubUser = MutableLiveData<RetrofitData>()
    val githubUser : MutableLiveData<RetrofitData>
        get() = _githubUser

    private val _githubRepo = MutableLiveData<ReposData>()
    val githubRepo : MutableLiveData<ReposData>
        get() = _githubRepo

    var tabPosition : Int = 0

    fun searchUser() = viewModelScope.launch {
        githubUser.value = repository.fetchUser(userName.value.toString())
    }

    fun searchRepo() = viewModelScope.launch {
        githubRepo.value = repository.fetchRepo(userName.value.toString())
    }

    fun saveSearchTerm() = viewModelScope.launch{
        repository.insertKeyword(RecentSearchTerm(0,userName.value.toString()))
    }

}