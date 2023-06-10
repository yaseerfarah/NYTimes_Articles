package com.yasser.nyarticles.modules.core.domain.interactors



import com.yasser.nyarticles.base.domain.interactors.SuspendUseCase
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.repository.ArticlesRepository
import javax.inject.Inject

class GetPopularArticlesUseCase @Inject constructor(
    private val repository: ArticlesRepository,
): SuspendUseCase<Unit, List<ArticleEntity>>() {
    override suspend fun invoke(params: Unit):  List<ArticleEntity> {
      return repository.getMostPopularArticles()
    }
}