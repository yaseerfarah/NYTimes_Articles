package com.yasser.nyarticles.core.network


import com.yasser.nyarticles.base.data.response.GenericResponse
import com.yasser.nyarticles.modules.core.data.model.response.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoints {



    @GET("viewed/7.json")
    suspend fun getMostPopularArticles(@Query("api-key") apiKey:String): Response<GenericResponse<List<ArticleResponse>>>





}