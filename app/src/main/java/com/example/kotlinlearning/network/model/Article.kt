package com.example.kotlinlearning.network.model

data class Article(
    val category: List<Category>,
    val excerpt: String,
    val post_date: String,
    val post_name: String,
    val post_title: String
)