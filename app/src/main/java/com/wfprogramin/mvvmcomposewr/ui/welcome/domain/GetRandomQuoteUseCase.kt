package com.wfprogramin.mvvmcomposewr.ui.welcome.domain

import com.wfprogramin.mvvmcomposewr.ui.welcome.data.QuoteRepository
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke():Quote?{
        val quotes = repository.getAllQuotesFromDatabase()

        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}