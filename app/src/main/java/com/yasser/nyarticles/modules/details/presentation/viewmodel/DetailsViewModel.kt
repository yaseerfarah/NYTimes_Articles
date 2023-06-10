package com.yasser.nyarticles.modules.details.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.yasser.nyarticles.base.presentation.viewmodel.StateViewModel
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.interactors.GetPopularArticlesUseCase
import com.yasser.nyarticles.modules.details.presentation.uimoddel.DetailsUiModel
import com.yasser.nyarticles.modules.details.presentation.uimoddel.DetailsUiState
import com.yasser.nyarticles.modules.details.presentation.uimoddel.toDetailsUiModel
import com.yasser.nyarticles.modules.home.presentation.uimoddel.HomeUiModel
import com.yasser.nyarticles.modules.home.presentation.uimoddel.HomeUiState
import com.yasser.nyarticles.modules.home.presentation.uimoddel.toArticleUiModel
import com.yasser.nyarticles.modules.home.presentation.uimoddel.toHomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel

import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor():
    StateViewModel<DetailsUiModel, DetailsUiState>(DetailsUiState(data = null, isLoading = true)) {



    override fun mapStateToUIModel(
        oldState: DetailsUiState,
        newState: DetailsUiState
    ): DetailsUiModel {
       return newState.data.toDetailsUiModel(newState.isLoading)
    }


    fun getData(articleEntity: ArticleEntity?){
        updateState(DetailsUiState(data = articleEntity, isLoading = false))
    }

    fun getArticleUrl():String{
       return state.data?.url?:""
    }


}