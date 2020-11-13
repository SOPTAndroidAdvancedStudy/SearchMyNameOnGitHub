package com.siba.searchmvvmpractice

import android.app.Application
import com.siba.searchmvvmpractice.singleton.KeyPreference

class SearchApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KeyPreference.init(this)
    }
}