package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewsRepository

class GetSaveNewsUseCase(private val newsRepository: NewsRepository) {
}