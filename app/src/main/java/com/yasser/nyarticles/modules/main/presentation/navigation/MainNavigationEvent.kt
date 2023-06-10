package com.yasser.nyarticles.modules.main.presentation.navigation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity

sealed class  MainNavigationEvent {

    object BackToHomeScreen: MainNavigationEvent()
    data class NavigateToDetailsScreen(val articleEntity: ArticleEntity): MainNavigationEvent()
    data class GoToWebsite(val activity: Context, val url: String): MainNavigationEvent()


}