package com.example.newsapiclient.data.repository.dataSourceImpl

import com.example.newsapiclient.data.api.NewsAPIService
import com.example.newsapiclient.data.model.ApiResponse
import com.example.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsAPIService
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(
        country: String,
        page: Int
    ): Response<ApiResponse> {
        return newsApiService.getTopHeadlines(country, page)
    }
}

