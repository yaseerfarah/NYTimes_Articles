package com.yasser.nyarticles.modules.core.data.repository


import com.yasser.nyarticles.modules.core.data.model.mapper.toListOfArticleEntity
import com.yasser.nyarticles.modules.core.data.source.ArticlesApiSource
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.repository.ArticlesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import java.net.ConnectException
import javax.inject.Inject

class FakeAndroidArticlesRepositoryImp constructor(): ArticlesRepository {

    private val listOfArticle= mutableListOf<ArticleEntity>()

    private var isNetworkError:Boolean=false

    private var  isUnexpectedError:Boolean=false


    fun setIsNetworkError(value:Boolean){
        isNetworkError=value
    }

    fun setIsUnexpectedError(value:Boolean){
        isUnexpectedError=value
    }

    fun addItemToListOfArticle(item:ArticleEntity){
        listOfArticle.add(item)
    }


    override suspend fun getMostPopularArticles(): List<ArticleEntity> {

        delay(1000)
        if (isNetworkError)
            throw (ConnectException())
        else if (isUnexpectedError)
            throw (Throwable("Something went wrong"))
        else
             return listOfArticle
    }


}