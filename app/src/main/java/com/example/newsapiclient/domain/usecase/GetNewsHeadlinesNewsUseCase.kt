package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesNewsUseCase(private val newsRepository: NewsRepository) {
}