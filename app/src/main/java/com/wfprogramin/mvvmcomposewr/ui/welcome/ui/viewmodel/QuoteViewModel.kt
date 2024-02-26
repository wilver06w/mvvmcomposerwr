package com.wfprogramin.mvvmcomposewr.ui.welcome.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.GetQuotesUseCase
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.GetRandomQuoteUseCase
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.model.Quote


import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase : GetQuotesUseCase,
    private val getRandomQuoteUseCase : GetRandomQuoteUseCase,
) : ViewModel() {

    val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(result.isNotEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        viewModelScope.launch {


        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()

        if(quote!=null){
            quoteModel.postValue(quote ?: quote)
        }
        isLoading.postValue(false)
    }
    }
}