package com.yasser.nyarticles.modules.details.presentation.viewmodel

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

    private lateinit var viewModel: DetailsViewModel

    @Before
    fun setup() {

        viewModel = DetailsViewModel()
    }


    @Test
    fun `first emit  return showLoading true`(){

        runBlocking {
            assertThat(viewModel.uiModel.first()).isEqualTo(DetailsUiModel(
                id=0,
                source = "",
                publishedDate="",
                section="",
                byline="",
                title="",
                abstract="",
                imageUrl="",
                keyWords = "",
                showUnexpectedError = false,
                errorMsg = null,
                isLoading = true
            ))
        }
    }



    @Test
    fun `article entity equal null  return showUnexpectedError true`(){

        val articleEntity :ArticleEntity?=null

        viewModel.getData(articleEntity)

        runBlocking {
            assertThat(viewModel.uiModel.first()).isEqualTo(articleEntity.toDetailsUiModel(false))
        }
    }



    @Test
    fun `article entity return DetailsUiModel`(){

        val articleEntity =ArticleEntity(
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

        viewModel.getData(articleEntity)

        runBlocking {
            assertThat(viewModel.uiModel.first()).isEqualTo(articleEntity.toDetailsUiModel(false))
        }
    }








}













