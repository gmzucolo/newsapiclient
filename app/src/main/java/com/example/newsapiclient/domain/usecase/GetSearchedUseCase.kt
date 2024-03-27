package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.util.Resource
import com.example.newsapiclient.domain.model.APIResponse
import com.example.newsapiclient.domain.repository.NewsRepository

class GetSearchedUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}