package com.wfprogramin.mvvmcomposewr.ui.welcome.domain

import com.wfprogramin.mvvmcomposewr.ui.welcome.data.QuoteRepository
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.database.entities.toDatabase
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

   return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes = quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}