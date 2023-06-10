package com.yasser.nyarticles.modules.home.presentation.uimoddel

import androidx.annotation.StringRes

data class HomeUiModel(
    val data:List<ArticleUiModel>,
    val showLoading:Boolean ,
    @StringRes val errorMsg:Int?,
    val showEmptyState:Boolean,
    val showNetworkError:Boolean,
    val showUnexpectedError:Boolean,


)
