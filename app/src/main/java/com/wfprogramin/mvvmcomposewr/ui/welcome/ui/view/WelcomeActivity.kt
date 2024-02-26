package com.wfprogramin.mvvmcomposewr.ui.welcome.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.wfprogramin.mvvmcomposewr.ui.theme.MvvmcomposewrTheme
import com.wfprogramin.mvvmcomposewr.ui.welcome.domain.model.Quote
import com.wfprogramin.mvvmcomposewr.ui.welcome.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeScreen : ComponentActivity() {

    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmcomposewrTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Body(quoteViewModel)
                }
            }
        }
    }
}

@Composable
fun Body(quoteViewModel: QuoteViewModel) {

    quoteViewModel.onCreate()

    val quote: Quote by quoteViewModel.quoteModel.observeAsState(
        initial = Quote(
            quote = "", author = ""
        )
    )
    val isLoading: Boolean by quoteViewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = Modifier.clickable {
            quoteViewModel.randomQuote()
        }) {

            Text(text = quote.quote, fontWeight = FontWeight.W500, fontSize = 50.sp)
            Text(text = quote.author)
        }
    }
}