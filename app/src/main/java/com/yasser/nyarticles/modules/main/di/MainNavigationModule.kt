package com.yasser.nyarticles.modules.main.di



import com.yasser.nyarticles.base.presentation.navigation.NavigationCoordinator
import com.yasser.nyarticles.modules.main.presentation.navigation.MainFlowNavigation
import com.yasser.nyarticles.modules.main.presentation.navigation.MainNavigationCoordinator
import com.yasser.nyarticles.modules.main.presentation.navigation.MainNavigationEvent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainNavigationModule {

    @Provides
    @Singleton
    fun provideMainNavigationCoordinator(
        mainFlowNavigation: MainFlowNavigation
    ): NavigationCoordinator<MainNavigationEvent> =
        MainNavigationCoordinator(
            mainFlowNavigation =mainFlowNavigation
        )
}
