package com.wfprogramin.mvvmcomposewr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wfprogramin.mvvmcomposewr.ui.login.ui.LoginScreen
import com.wfprogramin.mvvmcomposewr.ui.login.ui.LoginViewModel
import com.wfprogramin.mvvmcomposewr.ui.theme.MvvmcomposewrTheme

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