package com.siba.searchmvvmpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
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
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            searchViewModel = ViewModelProvider.NewInstanceFactory().create(SearchViewModel::class.java)
            fragmentManager = supportFragmentManager
            lifecycleOwner = this@MainActivity
        }

        binding.searchMain.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                //Toast.makeText(this@MainActivity, query!!, Toast.LENGTH_SHORT).show()
                binding.searchViewModel?.searchBook(query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //Toast.makeText(this@MainActivity, newText!!, Toast.LENGTH_SHORT).show()
                return false
            }

        })
    }
}