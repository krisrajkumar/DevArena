package com.app.hiltretrofit.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("region/europe")
    suspend fun getCountries(): Response<Countries>
}