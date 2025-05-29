package com.example.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Serie
import com.example.myapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SerieViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var series by mutableStateOf<List<Serie>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    private var currentPage = 1
    private var isLastPage = false

    init {
        loadNextPage()
    }

    fun loadNextPage() {
        if (isLoading || isLastPage) return

        isLoading = true
        viewModelScope.launch {
            try {
                val newSeries = repository.getPopularSeries(currentPage)
                if (newSeries.isNotEmpty()) {
                    series = series + newSeries
                    currentPage++
                } else {
                    isLastPage = true // plus de pages
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}