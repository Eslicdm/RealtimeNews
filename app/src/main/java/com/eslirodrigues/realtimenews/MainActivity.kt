package com.eslirodrigues.realtimenews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eslirodrigues.realtimenews.ui.screen.NewsListScreen
import com.eslirodrigues.realtimenews.ui.theme.RealtimeNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealtimeNewsTheme {
                NewsListScreen()
            }
        }
    }
}
