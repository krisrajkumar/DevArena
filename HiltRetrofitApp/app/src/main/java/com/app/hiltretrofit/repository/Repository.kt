package com.app.hiltretrofit.repository

import com.app.hiltretrofit.api.ApiService

class Repository(private val apiService: ApiService) {
    suspend fun getCountries() = apiService.getCountries()
}