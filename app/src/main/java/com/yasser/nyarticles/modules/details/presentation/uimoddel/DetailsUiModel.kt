package com.yasser.nyarticles.modules.details.presentation.uimoddel

import androidx.annotation.StringRes
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity

data class DetailsUiModel(
    val id: Long,
    val source: String,
    val publishedDate: String,
    val section: String,
    val keyWords:String,
    val byline: String,
    val title: String,
    val abstract: String,
    val imageUrl: String,
    val isLoading:Boolean,
    @StringRes val errorMsg:Int?,
    val showUnexpectedError:Boolean,)
