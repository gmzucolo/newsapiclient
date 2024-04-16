package com.example.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapiclient.domain.usecase.GetNewsHeadlinesNewsUseCase

class NewsViewModelFactory(
    private val application: Application,
    private val getNewsHeadlinesNewsUseCase: GetNewsHeadlinesNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(application, getNewsHeadlinesNewsUseCase) as T
    }
}