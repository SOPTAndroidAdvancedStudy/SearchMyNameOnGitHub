package com.siba.searchmvvmpractice.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.siba.searchmvvmpractice.ui.BestSellerSearchFragment
import com.siba.searchmvvmpractice.ui.BookSearchFragment

class SearchPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount() = 2
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> BookSearchFragment()
            else -> BestSellerSearchFragment()
        }
    }
}