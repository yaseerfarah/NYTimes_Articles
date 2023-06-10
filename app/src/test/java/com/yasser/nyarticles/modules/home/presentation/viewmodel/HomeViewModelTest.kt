package com.yasser.nyarticles.modules.home.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.yasser.nyarticles.MainCoroutineRule
import com.yasser.nyarticles.R
import com.yasser.nyarticles.modules.core.data.model.mapper.toListOfMediaImageEntity
import com.yasser.nyarticles.modules.core.data.repository.FakeArticlesRepositoryImp
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.interactors.GetPopularArticlesUseCase
import com.yasser.nyarticles.modules.home.presentation.uimoddel.HomeUiModel
import com.yasser.nyarticles.modules.home.presentation.uimoddel.toArticleUiModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ShoppingViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var fakeArticlesRepositoryImp: FakeArticlesRepositoryImp

    @Before
    fun setup() {
        fakeArticlesRepositoryImp=FakeArticlesRepositoryImp()
        val getPopularArticleUseCase=GetPopularArticlesUseCase(fakeArticlesRepositoryImp)
        viewModel = HomeViewModel(getPopularArticleUseCase)
    }


    @Test
    fun `first emit  return showLoading true`(){
        fakeArticlesRepositoryImp.setIsNetworkError(false)
        viewModel.getArticleData()

        runBlocking {
            assertThat(viewModel.uiModel.first()).isEqualTo(HomeUiModel(
                data = listOf(),
                showLoading = true,
                errorMsg = null,
                showEmptyState = false,
                showUnexpectedError = false,
                showNetworkError = false
            ))
        }




    }

   @Test
    fun `network Exception While call api return showNetworkError true`(){
       fakeArticlesRepositoryImp.setIsNetworkError(true)
       viewModel.getArticleData()

       runBlocking {
           assertThat(viewModel.uiModel.drop(1).first()).isEqualTo(HomeUiModel(
               data = listOf(),
               showLoading = false,
               errorMsg = R.string.msgNoInternetConnection,
               showEmptyState = false,
               showUnexpectedError = false,
               showNetworkError = true
           ))
       }


    }


    @Test
    fun `random Exception While call api return showUnexpectedError true`(){
        fakeArticlesRepositoryImp.setIsUnexpectedError(true)
        viewModel.getArticleData()

        runBlocking {
            assertThat(viewModel.uiModel.drop(1).first()).isEqualTo(HomeUiModel(
                data = listOf(),
                showLoading = false,
                errorMsg = R.string.msgUnexpextedError,
                showEmptyState = false,
                showUnexpectedError = true,
                showNetworkError = false
            ))
        }


    }


    @Test
    fun ` call api with empty result return showEmptyState true`(){
        viewModel.getArticleData()
        runBlocking {

            assertThat(viewModel.uiModel.drop(1).first()).isEqualTo(HomeUiModel(
                data = listOf(),
                showLoading = false,
                errorMsg = null,
                showEmptyState = true,
                showUnexpectedError = false,
                showNetworkError = false
            ))

        }


    }


    @Test
    fun ` call api with some data result return all state false with data list not empty`(){
        val articleEntity =ArticleEntity(
            id= 0,
            assetID= 0,
            url= "url",
            source= "source",
            publishedDate= "publishedDate",
            section= "section",
            subsection= "subsection",
            byline= "byline",
            type="type" ,
            keywords= listOf<String>(),
            title= "title",
            abstract= "abstract",
            mediaImage= listOf(),
        )
        fakeArticlesRepositoryImp.addItemToListOfArticle(articleEntity)
        viewModel.getArticleData()
        runBlocking {

            assertThat(viewModel.uiModel.drop(1).first()).isEqualTo(HomeUiModel(
                data = listOf(articleEntity.toArticleUiModel()),
                showLoading = false,
                errorMsg = null,
                showEmptyState = false,
                showUnexpectedError = false,
                showNetworkError = false
            ))

        }
    }

    @Test
    fun `find correct article entity by id`(){
        val articleEntity1 =ArticleEntity(
            id= 1,
            assetID= 0,
            url= "url",
            source= "source",
            publishedDate= "publishedDate",
            section= "section",
            subsection= "subsection",
            byline= "byline",
            type="type" ,
            keywords= listOf<String>(),
            title= "title",
            abstract= "abstract",
            mediaImage= listOf(),
        )
        val articleEntity2 =ArticleEntity(
            id= 2,
            assetID= 0,
            url= "url",
            source= "source",
            publishedDate= "publishedDate",
            section= "section",
            subsection= "subsection",
            byline= "byline",
            type="type" ,
            keywords= listOf<String>(),
            title= "title",
            abstract= "abstract",
            mediaImage= listOf(),
        )
        fakeArticlesRepositoryImp.addItemToListOfArticle(articleEntity1)
        fakeArticlesRepositoryImp.addItemToListOfArticle(articleEntity2)
        viewModel.getArticleData()

        runBlocking {
            delay(1100)
            assertThat(viewModel.getArticleEntityById(articleEntity1.id)).isEqualTo(articleEntity1)
        }


    }


}













