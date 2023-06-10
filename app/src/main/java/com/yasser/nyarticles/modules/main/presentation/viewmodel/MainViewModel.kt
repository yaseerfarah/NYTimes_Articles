package com.yasser.nyarticles.modules.main.presentation.viewmodel

import android.content.Context
import com.yasser.nyarticles.base.presentation.viewmodel.StateViewModel
import com.yasser.nyarticles.modules.main.presentation.uimodel.MainScreensEnum
import com.yasser.nyarticles.modules.main.presentation.uimodel.MainUiModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor():
    StateViewModel<MainUiModel, MainUiState>(MainUiState(currentScreen = MainScreensEnum.HOME)) {
    override fun mapStateToUIModel(oldState: MainUiState, newState: MainUiState): MainUiModel {
        return MainUiModel(
            currentScreen = newState.currentScreen
        )
    }



     fun setCurrentScreen(currentScreen: MainScreensEnum){

        updateState(state.copy(currentScreen = currentScreen))

    }

    fun isFirstScreen():Boolean{
        return state.currentScreen==MainScreensEnum.HOME
    }


}