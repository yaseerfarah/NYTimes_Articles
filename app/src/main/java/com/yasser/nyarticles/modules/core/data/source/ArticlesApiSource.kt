package com.yasser.nyarticles.modules.core.data.source


import com.google.gson.Gson
import com.yasser.nyarticles.BuildConfig
import com.yasser.nyarticles.core.network.ApiEndpoints
import com.yasser.nyarticles.modules.core.data.model.response.ArticleResponse

import javax.inject.Inject

class ArticlesApiSource @Inject constructor(
    private val apiEndpoints: ApiEndpoints
) {

    suspend fun getMostPopularArticles():List<ArticleResponse>{
        val listOfArticle = mutableListOf<ArticleResponse>()
        val response= apiEndpoints.getMostPopularArticles(
            apiKey = BuildConfig.ApiKey
        )
        if (response.isSuccessful){
            response.body()?.results?.let {
                listOfArticle.addAll(it)
            }
        }else{
            val message = "Something went wrong"
            Throwable(message)
        }
        return listOfArticle
    }




}