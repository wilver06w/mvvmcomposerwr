package com.wfprogramin.mvvmcomposewr

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.wfprogramin.mvvmcomposewr.ui.login.ui.LoginScreen
import com.wfprogramin.mvvmcomposewr.ui.login.ui.LoginViewModel
import com.wfprogramin.mvvmcomposewr.ui.theme.MvvmcomposewrTheme
import com.wfprogramin.mvvmcomposewr.ui.welcome.ui.view.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmcomposewrTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(LoginViewModel())
                }
            }
        }
    }
}



//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//
//    private val quoteViewModel: QuoteViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        quoteViewModel.onCreate()
//
//        setContent {
//            MvvmcomposewrTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background,
//                ) {
//                    Body(quoteViewModel)
//                }
//            }
//        }
//    }