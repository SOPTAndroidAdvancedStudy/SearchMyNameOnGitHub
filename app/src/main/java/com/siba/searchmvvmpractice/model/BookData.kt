package com.siba.searchmvvmpractice.model

data class SearchBookData (
    val item: List<BookData>
) data class BookData (
    val coverSmallUrl: String,
    val title: String,
    val author: String,
)