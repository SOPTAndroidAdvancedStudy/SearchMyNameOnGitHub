package com.siba.searchmvvmpractice.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.siba.searchmvvmpractice.R
import com.siba.searchmvvmpractice.databinding.FragmentBookSearchBinding
import com.siba.searchmvvmpractice.viewmodel.SearchViewModel

class BookSearchFragment : Fragment() {
    private lateinit var binding: FragmentBookSearchBinding
    private val searchViewModel: SearchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_search, container, false)
        binding.lifecycleOwner = this
        binding.searchViewModel = searchViewModel
        return binding.root
    }

}