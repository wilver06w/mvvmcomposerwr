package com.wfprogramin.mvvmcomposewr.ui.welcome.data

import com.wfprogramin.mvvmcomposewr.ui.welcome.data.database.dao.QuoteDao
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.database.entities.QuoteEntity
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.model.QuoteModel
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.network.QuoteService
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.model.Quote
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteDao: QuoteDao) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map{
            it.toDomain()
        }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}