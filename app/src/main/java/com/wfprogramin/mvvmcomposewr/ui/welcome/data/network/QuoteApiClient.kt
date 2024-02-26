package com.wfprogramin.mvvmcomposewr.ui.welcome.data.network

import com.wfprogramin.mvvmcomposewr.ui.welcome.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}