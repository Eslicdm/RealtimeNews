package com.eslirodrigues.realtimenews.ui.screen



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eslirodrigues.realtimenews.ui.theme.DarkBlue
import com.eslirodrigues.realtimenews.ui.viewmodel.NewsViewModel
import com.eslirodrigues.realtimenews.util.NewsState

@Composable
fun NewsListScreen(viewModel: NewsViewModel = viewModel()) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(DarkBlue)
    ) {
        when(val result = viewModel.response.value) {
            is NewsState.Success -> {
                LazyColumn {
                    items(result.data) { item ->
                        NewsListItem(news = item)
                    }
                }
            }
            is NewsState.Failure -> {
                Text(text = "${result.msg}")
            }
            is NewsState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is NewsState.Empty -> {
                Text(text = "Empty")
            }
        }
    }
}