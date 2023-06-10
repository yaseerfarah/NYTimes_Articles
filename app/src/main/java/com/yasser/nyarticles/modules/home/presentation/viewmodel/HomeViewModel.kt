package com.yasser.nyarticles.modules.home.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.yasser.nyarticles.base.presentation.viewmodel.StateViewModel
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.interactors.GetPopularArticlesUseCase
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
class HomeViewModel @Inject constructor(
    private val getPopularArticlesUseCase: GetPopularArticlesUseCase,
    ):
    StateViewModel<HomeUiModel, HomeUiState>(HomeUiState(data = listOf(), isLoading = true, errorMsg = null, isNetworkError = false)) {



    override fun mapStateToUIModel(oldState: HomeUiState, newState: HomeUiState): HomeUiModel {
        return HomeUiModel(
            data = newState.data.map { it.toArticleUiModel() },
            errorMsg = newState.errorMsg,
            showLoading = newState.isLoading,
            showNetworkError = newState.isNetworkError && newState.errorMsg!=null,
            showUnexpectedError = newState.errorMsg!=null && newState.data.isEmpty() && !newState.isNetworkError,
            showEmptyState = newState.data.isEmpty()&&newState.errorMsg==null&&!newState.isLoading
        )
    }



     fun getArticleData(){
        if (state.data.isEmpty()) {
            updateState(
                HomeUiState(
                    data = listOf(),
                    isLoading = true,
                    errorMsg = null,
                    isNetworkError = false
                )
            )
            viewModelScope.launch {
                try {
                    val articleData =
                        withContext(Dispatchers.IO) { getPopularArticlesUseCase(Unit) }
                    updateState(articleData.toHomeUiState())
                } catch (e: Throwable) {
                    updateState(e.toHomeUiState())
                }
            }
        }
    }


    fun getArticleEntityById(id:Long):ArticleEntity?{
        return state.data.find { it.id == id }
    }



}