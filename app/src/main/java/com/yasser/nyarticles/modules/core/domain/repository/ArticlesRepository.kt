package com.yasser.nyarticles.modules.core.domain.repository

import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity


interface ArticlesRepository {

    suspend fun getMostPopularArticles():List<ArticleEntity>

}