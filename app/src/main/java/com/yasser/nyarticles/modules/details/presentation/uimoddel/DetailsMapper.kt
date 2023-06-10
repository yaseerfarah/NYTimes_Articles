package com.yasser.nyarticles.modules.details.presentation.uimoddel

import com.yasser.nyarticles.R
import com.yasser.nyarticles.core.extensions.convertToDate
import com.yasser.nyarticles.core.extensions.convertToUiDate
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.home.presentation.uimoddel.ArticleUiModel


fun ArticleEntity?.toDetailsUiModel(isLoading:Boolean):DetailsUiModel{
    return if (this!=null)
        DetailsUiModel(
            id=id,
            source = source,
            publishedDate=publishedDate.convertToDate()?.convertToUiDate()?:publishedDate,
            section=section,
            byline=byline,
            title=title,
            abstract=abstract,
            imageUrl=mediaImage.firstOrNull()?.listOfImage?.lastOrNull()?:"",
            keyWords = keywords.toString(),
            showUnexpectedError = false,
            errorMsg = null,
            isLoading = false
    )
    else
        DetailsUiModel(
            id=0,
            source = "",
            publishedDate="",
            section="",
            byline="",
            title="",
            abstract="",
            imageUrl="",
            keyWords = "",
            showUnexpectedError = !isLoading,
            errorMsg = if(isLoading)null else  R.string.msgUnexpextedError,
            isLoading = isLoading
        )

}