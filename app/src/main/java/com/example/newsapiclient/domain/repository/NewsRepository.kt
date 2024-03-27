package com.example.newsapiclient.domain.repository

import com.example.newsapiclient.data.util.Resource
import com.example.newsapiclient.domain.model.APIResponse
import com.example.newsapiclient.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}