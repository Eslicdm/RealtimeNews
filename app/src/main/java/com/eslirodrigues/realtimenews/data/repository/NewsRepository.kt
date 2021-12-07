package com.eslirodrigues.realtimenews.data.repository

import androidx.lifecycle.MutableLiveData
import com.eslirodrigues.realtimenews.data.model.News
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NewsRepository {

    private val database = Firebase.database
    init {
        database.setPersistenceEnabled(true)
    }
    private val newsReference = database.getReference("news")

    fun getNews(liveData: MutableLiveData<List<News>>) {
        newsReference.keepSynced(true)
        newsReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val newsItems: List<News> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(News::class.java)!!.copy(id = dataSnapshot.key!!)
                    }

                    liveData.postValue(newsItems)
                }

                override fun onCancelled(error: DatabaseError) {
                    /* TODO */
                }
            })
    }
}