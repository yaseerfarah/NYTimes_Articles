package com.yasser.nyarticles.modules.main.presentation.navigation

import android.content.Context
import androidx.navigation.NavController
import com.yasser.nyarticles.base.presentation.navigation.NavigationCoordinator
import com.yasser.nyarticles.modules.main.presentation.navigation.MainFlowNavigation
import com.yasser.nyarticles.modules.main.presentation.navigation.MainNavigationEvent
import com.yasser.nyarticles.modules.main.presentation.view.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
 open class MainNavigationCoordinator @Inject constructor(
    private val mainFlowNavigation: MainFlowNavigation
)
    : NavigationCoordinator<MainNavigationEvent>() {

     override fun init(param: Any) {
         mainFlowNavigation.setNavController(param as NavController)
     }

     override fun onStart(context: Context?, param: Any?) {
         MainActivity.startInstance(context)
     }

     override fun onEvent(event: MainNavigationEvent) {
         when(event){
             is MainNavigationEvent.BackToHomeScreen->mainFlowNavigation.backToHomeScreen()
             is MainNavigationEvent.NavigateToDetailsScreen->mainFlowNavigation.navigateToDetailsScreen(event.articleEntity)
             is MainNavigationEvent.GoToWebsite -> mainFlowNavigation.openArticleOnWebsite(event.activity,event.url)
         }
     }


 }