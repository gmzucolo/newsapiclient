package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.util.Resource
import com.example.newsapiclient.domain.model.APIResponse
import com.example.newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines()
    }
}