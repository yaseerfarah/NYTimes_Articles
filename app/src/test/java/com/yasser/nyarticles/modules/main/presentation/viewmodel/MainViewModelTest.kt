package com.yasser.nyarticles.modules.main.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.yasser.nyarticles.MainCoroutineRule
import com.yasser.nyarticles.R
import com.yasser.nyarticles.core.extensions.convertToDate
import com.yasser.nyarticles.core.extensions.convertToUiDate
import com.yasser.nyarticles.modules.core.data.model.mapper.toListOfMediaImageEntity
import com.yasser.nyarticles.modules.core.data.repository.FakeArticlesRepositoryImp
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.interactors.GetPopularArticlesUseCase
import com.yasser.nyarticles.modules.details.presentation.uimoddel.DetailsUiModel
import com.yasser.nyarticles.modules.details.presentation.uimoddel.toDetailsUiModel
import com.yasser.nyarticles.modules.home.presentation.uimoddel.HomeUiModel
import com.yasser.nyarticles.modules.home.presentation.uimoddel.toArticleUiModel
import com.yasser.nyarticles.modules.main.presentation.uimodel.MainScreensEnum
import com.yasser.nyarticles.modules.splash.presentation.uimodel.SplashUiModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {

        viewModel = MainViewModel()
    }


    @Test
    fun `set current screen home return isFirstScreen  true`(){

        viewModel.setCurrentScreen(MainScreensEnum.HOME)

        assertThat(viewModel.isFirstScreen()).isTrue()
    }



    @Test
    fun `set current screen details return isFirstScreen  true`(){

        viewModel.setCurrentScreen(MainScreensEnum.DETAILS)

        assertThat(viewModel.isFirstScreen()).isFalse()
    }










}













