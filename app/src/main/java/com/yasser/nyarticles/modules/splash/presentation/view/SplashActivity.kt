package com.yasser.nyarticles.modules.splash.presentation.view

import androidx.activity.viewModels
import com.yasser.nyarticles.base.presentation.navigation.NavigationCoordinator
import com.yasser.nyarticles.base.presentation.view.BaseActivity
import com.yasser.nyarticles.core.navigation.RootNavigationEvent
import com.yasser.nyarticles.databinding.ActivitySplashBinding
import com.yasser.nyarticles.modules.splash.presentation.uimodel.SplashUiModel
import com.yasser.nyarticles.modules.splash.presentation.uimodel.SplashUiState
import com.yasser.nyarticles.modules.splash.presentation.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashUiModel, SplashUiState, SplashViewModel>(){
    override val viewModel by viewModels<SplashViewModel>()

    @Inject
    lateinit var rootNavigation: NavigationCoordinator<RootNavigationEvent>

    override fun bindView(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun handleOrientation() {

    }

    override fun initViews() {
        viewModel.startSplashDelay()
    }

    override fun initListener() {

    }

    override fun render(ui: SplashUiModel) {
        if (ui.navigateToNextScreen)
            rootNavigation.onStart(this)
    }


}