package com.eslirodrigues.realtimenews.util

import com.eslirodrigues.realtimenews.data.model.News

sealed class NewsState {
    class Success(val data: List<News>) : NewsState()
    class Failure(val msg: Throwable) : NewsState()
    object Loading : NewsState()
    object Empty : NewsState()
}