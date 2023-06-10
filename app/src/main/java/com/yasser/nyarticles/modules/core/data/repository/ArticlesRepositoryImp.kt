package com.yasser.nyarticles.modules.core.data.repository


import com.yasser.nyarticles.modules.core.data.model.mapper.toListOfArticleEntity
import com.yasser.nyarticles.modules.core.data.source.ArticlesApiSource
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.repository.ArticlesRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import javax.inject.Inject

class ArticlesRepositoryImp@Inject constructor(
    private val source: ArticlesApiSource
): ArticlesRepository {

    override suspend fun getMostPopularArticles(): List<ArticleEntity> {
       return source.getMostPopularArticles().toListOfArticleEntity()
    }


}