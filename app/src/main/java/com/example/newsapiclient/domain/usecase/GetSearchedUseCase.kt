package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.domain.repository.NewsRepository

class GetSearchedUseCase(private val newsRepository: NewsRepository) {
}