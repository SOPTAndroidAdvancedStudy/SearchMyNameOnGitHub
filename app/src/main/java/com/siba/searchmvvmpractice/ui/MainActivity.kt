package com.siba.searchmvvmpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.siba.searchmvvmpractice.R
import com.siba.searchmvvmpractice.databinding.ActivityMainBinding
import com.siba.searchmvvmpractice.viewmodel.SearchViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            searchViewModel = ViewModelProvider.NewInstanceFactory().create(SearchViewModel::class.java)
            fragmentManager = supportFragmentManager
            lifecycleOwner = this@MainActivity
        }
    }
}