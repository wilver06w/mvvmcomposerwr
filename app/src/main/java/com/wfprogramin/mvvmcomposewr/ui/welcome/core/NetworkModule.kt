package com.wfprogramin.mvvmcomposewr.ui.welcome.core

import com.wfprogramin.mvvmcomposewr.ui.welcome.data.network.QuoteApiClient
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.values.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn
object NetworkModule {
    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}