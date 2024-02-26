package com.wfprogramin.mvvmcomposewr.ui.welcome.domain.model

import com.wfprogramin.mvvmcomposewr.ui.welcome.data.database.entities.QuoteEntity
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)