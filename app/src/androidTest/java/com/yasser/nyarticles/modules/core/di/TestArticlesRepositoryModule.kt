package com.yasser.nyarticles.modules.core.di


import com.yasser.nyarticles.modules.core.data.repository.ArticlesRepositoryImp
import com.yasser.nyarticles.modules.core.data.repository.FakeAndroidArticlesRepositoryImp
import com.yasser.nyarticles.modules.core.domain.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class TestArticlesRepositoryModule {
   @Binds
   @Named("test_repository")
   abstract fun getArticlesRepository(imp: FakeAndroidArticlesRepositoryImp): ArticlesRepository

}