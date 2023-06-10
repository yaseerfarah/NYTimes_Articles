package com.yasser.nyarticles.modules.core.di


import com.yasser.nyarticles.modules.core.data.repository.ArticlesRepositoryImp
import com.yasser.nyarticles.modules.core.domain.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ArticlesRepositoryModule {
   @Binds
   abstract fun getArticlesRepository(imp: ArticlesRepositoryImp): ArticlesRepository

}