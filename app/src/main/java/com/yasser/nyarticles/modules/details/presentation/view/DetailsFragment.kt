package com.yasser.nyarticles.modules.details.presentation.view

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.chip.Chip
import com.yasser.nyarticles.R
import com.yasser.nyarticles.base.presentation.navigation.NavigationCoordinator
import com.yasser.nyarticles.base.presentation.view.BaseFragment
import com.yasser.nyarticles.base.presentation.view.customview.showLoading
import com.yasser.nyarticles.core.extensions.loadImage
import com.yasser.nyarticles.core.extensions.onClick
import com.yasser.nyarticles.databinding.FragmentDetailsBinding
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.main.presentation.navigation.MainNavigationEvent
import com.yasser.nyarticles.modules.details.presentation.uimoddel.DetailsUiModel
import com.yasser.nyarticles.modules.details.presentation.uimoddel.DetailsUiState
import com.yasser.nyarticles.modules.details.presentation.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsUiModel,DetailsUiState,DetailsViewModel>() {


    override val viewModel by viewModels<DetailsViewModel> ()

    @Inject
    lateinit var navigation: NavigationCoordinator<MainNavigationEvent>



    override fun bindView(): FragmentDetailsBinding {
        return FragmentDetailsBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        viewModel.getData(arguments?.getParcelable(DETAILS_PARAM))
    }

    override fun initListener() {
       binding.backBtn.onClick {
           navigation.onEvent(MainNavigationEvent.BackToHomeScreen)
       }

        binding.browserBtn.onClick {
            navigation.onEvent(MainNavigationEvent.GoToWebsite(requireActivity(),viewModel.getArticleUrl()))
        }
    }


    override fun render(ui: DetailsUiModel) {

        binding.articleCover.loadImage(ui.imageUrl,placeholderDrawable = null, progressBar = binding.progressBar)
        binding.details.title.text=ui.title
        binding.details.section.text=ui.section
        binding.details.date.text=ui.publishedDate
        binding.details.writer.text=ui.byline
        binding.details.description.text=ui.abstract
        binding.details.keywordsValues.text=ui.keyWords
        binding.stateView.showLoading(ui.isLoading)
        when{
            ui.showUnexpectedError->{
                binding.stateView.setError(
                    message = ui.errorMsg!!, retryAction = {
                        viewModel.getData(arguments?.getParcelable(DETAILS_PARAM))
                    }, retryTextColor = R.color.white, retryBackground = R.drawable.ic_retry_btn_bg, backgroundColor = R.color.white, retryIcon = R.drawable.ic_retry
                )
            }
        }
    }


    companion object{
        const val DETAILS_PARAM:String="Details_Param"
    }

}