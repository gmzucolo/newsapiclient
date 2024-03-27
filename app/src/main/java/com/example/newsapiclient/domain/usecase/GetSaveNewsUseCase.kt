package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.model.Article
import com.example.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSaveNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}