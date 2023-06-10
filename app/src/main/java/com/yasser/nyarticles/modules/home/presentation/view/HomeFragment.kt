package com.yasser.nyarticles.modules.home.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yasser.nyarticles.R
import com.yasser.nyarticles.base.presentation.navigation.NavigationCoordinator
import com.yasser.nyarticles.base.presentation.view.BaseFragment
import com.yasser.nyarticles.base.presentation.view.customview.showLoading
import com.yasser.nyarticles.databinding.FragmentHomeBinding
import com.yasser.nyarticles.modules.main.presentation.navigation.MainNavigationEvent
import com.yasser.nyarticles.modules.home.presentation.adapters.ArticleListAdapter
import com.yasser.nyarticles.modules.home.presentation.uimoddel.HomeUiModel
import com.yasser.nyarticles.modules.home.presentation.uimoddel.HomeUiState
import com.yasser.nyarticles.modules.home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding,HomeUiModel,HomeUiState,HomeViewModel>(){



    override val viewModel by viewModels<HomeViewModel> ()

    @Inject
    lateinit var navigation:NavigationCoordinator<MainNavigationEvent>

    private val articleListAdapter by lazy {
        ArticleListAdapter(requireContext()){articleUiModel->
            viewModel.getArticleEntityById(articleUiModel.id)?.let {
                navigation.onEvent(MainNavigationEvent.NavigateToDetailsScreen(it))
            }

        }
    }

    override fun bindView(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initViews() {
        binding.articleRecycler.apply {
            adapter=articleListAdapter
            layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        }
        viewModel.getArticleData()
    }

    override fun initListener() {

    }

    override fun render(ui: HomeUiModel) {

            articleListAdapter.submitList( ui.data)

        binding.stateView.showLoading(ui.showLoading)
        when{
            ui.showNetworkError->{
                binding.stateView.setNetworkError(message = resources.getString(ui.errorMsg!!), retryAction = {
                    viewModel.getArticleData()
                }, retryTextColor = R.color.white,backgroundColor = R.color.white, retryBackground = R.drawable.ic_retry_btn_bg, retryIcon = R.drawable.ic_retry)
            }
            ui.showUnexpectedError->{
                binding.stateView.setError(
                    message = ui.errorMsg!!, retryAction = {
                        viewModel.getArticleData()
                    }, retryTextColor = R.color.white, retryBackground = R.drawable.ic_retry_btn_bg, backgroundColor = R.color.white, retryIcon = R.drawable.ic_retry
                )
            }
            ui.showEmptyState->{
                binding.stateView.setEmpty(emptyMsg = R.string.empty)
            }
        }
    }


}