package com.yasser.nyarticles.core.navigation.di



import com.yasser.nyarticles.base.presentation.navigation.NavigationCoordinator
import com.yasser.nyarticles.core.navigation.RootFlowNavigation
import com.yasser.nyarticles.core.navigation.RootNavigationCoordinator
import com.yasser.nyarticles.core.navigation.RootNavigationEvent
import com.yasser.nyarticles.modules.main.presentation.navigation.MainNavigationEvent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RootNavigationModule {

    @Provides
    @Singleton
    fun provideRootNavigationCoordinator(
        rootFlowNavigation: RootFlowNavigation,
        mainNavigationCoordinator: NavigationCoordinator<MainNavigationEvent>
    ): NavigationCoordinator<RootNavigationEvent> =
        RootNavigationCoordinator(
            rootFlowNavigation=rootFlowNavigation,
            mainNavigationCoordinator=mainNavigationCoordinator
        )
}
