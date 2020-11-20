package com.siba.searchmvvmpractice.singleton

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.siba.searchmvvmpractice.adapter.SearchPagerAdapter
import com.siba.searchmvvmpractice.adapter.SearchViewAdapter
import com.siba.searchmvvmpractice.model.BookData
import com.siba.searchmvvmpractice.model.SearchBookData
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
            ) {
            }

            override fun onPageSelected(position: Int) {
                viewModel.selectPosition(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })
    }

    @BindingAdapter("setViewPosition")
    @JvmStatic
    fun setViewPosition(view: View, position: Int) {
        when (view) {
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

    @BindingAdapter("setImgFromUrl")
    @JvmStatic
    fun setImageFromUrl(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }

    @BindingAdapter("setRVAdapter")
    @JvmStatic
    fun setRecyclerViewAdapter(view: RecyclerView, data: LiveData<SearchBookData>?) {
        val adapter = data?.value?.let { SearchViewAdapter(it) }
        view.adapter = adapter
        adapter?.notifyDataSetChanged()
    }
}