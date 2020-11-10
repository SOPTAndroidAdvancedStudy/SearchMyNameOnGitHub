package com.siba.searchmvvmpractice.singleton

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.siba.searchmvvmpractice.adapter.SearchPagerAdapter
import com.siba.searchmvvmpractice.viewmodel.SearchViewModel

object CustomAdapter {

    @BindingAdapter("setTabItem", "setViewModel")
    @JvmStatic
    fun setTapContents(tabLayout: TabLayout, items: List<String>?, viewModel: SearchViewModel?) {
        items?.forEach { tabName ->
            with(tabLayout) {
                newTab().let { tab ->
                    tab.text = tabName
                    addTab(tab)
                }
                addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        tab?.position?.let { position ->
                            viewModel?.selectPosition(position)
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {}

                    override fun onTabReselected(tab: TabLayout.Tab?) {}

                })
            }
        }
    }

    @BindingAdapter("setFragmentManager", "setViewModel")
    @JvmStatic
    fun setViewPager(
        viewPager: ViewPager,
        fragmentManager: FragmentManager,
        viewModel: SearchViewModel
    ) {
        viewPager.adapter = SearchPagerAdapter(fragmentManager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { }

            override fun onPageSelected(position: Int) {
                viewModel.selectPosition(position)
            }

            override fun onPageScrollStateChanged(state: Int) { }

        })
    }

    @BindingAdapter("setViewPosition")
    @JvmStatic
    fun setViewPosition(view: View, position: Int) {
        when(view) {
            is ViewPager -> {
                view.currentItem = position
            }
            is TabLayout -> {
                view.run {
                    getTabAt(position)?.let { tab ->
                        selectTab(tab)
                    }
                }
            }
        }
    }
}