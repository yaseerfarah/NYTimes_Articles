package com.yasser.nyarticles.modules.details.presentation.uimoddel

import androidx.annotation.StringRes
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity

data class DetailsUiState(val data:ArticleEntity?,val isLoading:Boolean)
