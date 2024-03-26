package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewsRepository

class DeleteSaveNewsUseCase(private val newsRepository: NewsRepository) {
}