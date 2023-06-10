package com.yasser.nyarticles.modules.home.presentation.uimoddel

import androidx.annotation.StringRes
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity

data class HomeUiState(val data:List<ArticleEntity> = listOf() , val isLoading:Boolean , @StringRes val errorMsg:Int?, val isNetworkError:Boolean)
