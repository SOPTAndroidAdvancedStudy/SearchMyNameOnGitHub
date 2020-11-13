package com.siba.searchmvvmpractice.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.siba.searchmvvmpractice.R
import com.siba.searchmvvmpractice.databinding.ItemSearchBookBinding
import com.siba.searchmvvmpractice.model.BookData

class SearchViewAdapter(var datas: MutableList<BookData>) : RecyclerView.Adapter<SearchViewAdapter.SearchViewHolder>() {

    inner class SearchViewHolder(private val binding: ItemSearchBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BookData) {
            Log.d("data", "${data}")
            binding.bookData = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemSearchBookBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_search_book, parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount() = datas.size
}