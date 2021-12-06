package com.eslirodrigues.realtimenews.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.eslirodrigues.realtimenews.data.model.News
import com.eslirodrigues.realtimenews.data.repository.NewsRepository
import com.eslirodrigues.realtimenews.util.NewsState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    val response: MutableState<NewsState> = mutableStateOf(NewsState.Empty)

    private val _news = MutableLiveData<List<News>>()
    private val news: LiveData<List<News>> = _news

    init {
        getAllNews()
        getNewsFromRepository()
    }

    private fun getNewsFromRepository() {
        repository.getNews(_news)
    }

    private fun getAllNews() = viewModelScope.launch {
        news.asFlow()
            .onStart {
                response.value = NewsState.Loading
            }
            .catch {
                response.value = NewsState.Failure(it)
            }
            .collect {
                response.value = NewsState.Success(it)
            }
    }

}