package com.yasser.nyarticles.modules.home.presentation.uimoddel

import com.yasser.nyarticles.R
import com.yasser.nyarticles.core.extensions.convertToDate
import com.yasser.nyarticles.core.extensions.convertToUiDate
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import java.net.ConnectException
import java.net.UnknownHostException


fun List<ArticleEntity>.toHomeUiState():HomeUiState{
    return HomeUiState(
        data = this,
        isLoading = false,
        isNetworkError = false,
        errorMsg = null
    )
}



fun ArticleEntity.toArticleUiModel():ArticleUiModel{
    return ArticleUiModel(
        id=id,
        source = source,
        publishedDate=publishedDate.convertToDate()?.convertToUiDate()?:publishedDate,
        section=section,
        byline=byline,
        title=title,
        abstract=abstract,
        imageUrl=mediaImage.firstOrNull()?.listOfImage?.lastOrNull()?:"",
    )
}


fun Throwable.toHomeUiState():HomeUiState{
    return HomeUiState(
        data = listOf(),
        isLoading = false,
        errorMsg = this.getErrorMessageResource(),
        isNetworkError = this is ConnectException
    )
}

fun Throwable.getErrorMessageResource():Int{
    return when(this){
        is ConnectException , is UnknownHostException -> R.string.msgNoInternetConnection
        else -> R.string.msgUnexpextedError
    }
}