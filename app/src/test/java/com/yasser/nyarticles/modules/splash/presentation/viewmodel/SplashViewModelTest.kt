package com.yasser.nyarticles.modules.splash.presentation.viewmodel

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
class SplashViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: SplashViewModel

    @Before
    fun setup() {

        viewModel = SplashViewModel()
    }


    @Test
    fun `navigate to next screen after 2 second return navigateToNextScreen  true`(){

        viewModel.startSplashDelay()

        runTest {
            delay(3000)
            assertThat(viewModel.uiModel.first()).isEqualTo(SplashUiModel(
                navigateToNextScreen = true
            ))
        }
    }




    @Test
    fun `navigate to next screen before 2 second return navigateToNextScreen false`(){
        viewModel.startSplashDelay()
        runTest {
            delay(1000)
            assertThat(viewModel.uiModel.first()).isEqualTo(SplashUiModel(
                navigateToNextScreen = false
            ))
        }
    }






}













