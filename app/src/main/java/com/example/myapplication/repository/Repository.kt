package com.example.myapplication.repository

import com.example.myapplication.model.Serie
import com.example.myapplication.service.SerieApi
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: SerieApi
) {
    suspend fun getPopularSeries(page: Int = 1): List<Serie> {
        val response = api.getPopularSeries(page)
        if (response.isSuccessful) {
            return response.body()?.tv_shows ?: emptyList()
        } else {
            throw Exception("Erreur API: ${response.message()}")
        }
    }
}