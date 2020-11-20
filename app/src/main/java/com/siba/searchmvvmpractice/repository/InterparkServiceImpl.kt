package com.siba.searchmvvmpractice.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object InterparkServiceImpl {

    private const val INTERPARK_BASE_URL = "https://book.interpark.com/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(INTERPARK_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    fun getService(): InterparkService = retrofit.create(InterparkService::class.java)
}