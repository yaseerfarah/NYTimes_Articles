package com.yasser.nyarticles.modules.main.presentation.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.yasser.nyarticles.R
import com.yasser.nyarticles.base.presentation.navigation.NavigationCoordinator
import com.yasser.nyarticles.base.presentation.view.BaseActivity
import com.yasser.nyarticles.databinding.ActivityMainBinding
import com.yasser.nyarticles.modules.main.presentation.navigation.MainNavigationEvent
import com.yasser.nyarticles.modules.main.presentation.uimodel.MainScreensEnum
import com.yasser.nyarticles.modules.main.presentation.uimodel.MainUiModel
import com.yasser.nyarticles.modules.main.presentation.viewmodel.MainViewModel
import com.yasser.thmanyahtask.modules.main.presentation.uimodel.MainUiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding,MainUiModel,MainUiState,MainViewModel>(),
    NavController.OnDestinationChangedListener {
    override val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var navigation: NavigationCoordinator<MainNavigationEvent>


    private  val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navHostFragment.navController
    }

    override fun bindView(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onStart() {
        super.onStart()
        navController.addOnDestinationChangedListener(this)
    }

    override fun onStop() {
        super.onStop()
        navController.removeOnDestinationChangedListener(this)
    }

    override fun handleOrientation() {

    }

    override fun initViews() {
        navigation.init(navController)
        onBackPress()
    }

    override fun initListener() {

    }

    override fun render(ui: MainUiModel) {

    }

    private fun onBackPress() {
        onBackPressedDispatcher.addCallback(
            this /* lifecycle owner */,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!viewModel.isFirstScreen())
                        navigation.onEvent(MainNavigationEvent.BackToHomeScreen)
                    else
                        finish()
                }
            })


    }


    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when(destination.id){
            R.id.homeFragment->viewModel.setCurrentScreen(MainScreensEnum.HOME)
            R.id.detailsFragment->viewModel.setCurrentScreen(MainScreensEnum.DETAILS)
        }
    }

    companion object{

        fun startInstance(context: Context?) {
            context?.startActivity(
                Intent(context, MainActivity::class.java).apply {
                }
            )
            (context as Activity).finishAffinity()

        }

    }



}


