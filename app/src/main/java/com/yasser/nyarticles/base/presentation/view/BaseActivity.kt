package com.yasser.nyarticles.base.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.yasser.nyarticles.base.presentation.viewmodel.StateViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


abstract class BaseActivity<T : ViewBinding, UIModel,UIState,VM : StateViewModel<UIModel, UIState>>(
) : AppCompatActivity() {


    protected abstract val viewModel: VM

    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        handleOrientation()
        binding = bindView()
        setContentView(binding.root)
        initViews()
        initListener()

        lifecycleScope.launch  {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiModel.collectLatest { uiModel ->
                    render(uiModel)
                }
            }
        }
    }

    protected abstract fun bindView(): T
    protected abstract fun handleOrientation()
    abstract fun initViews()
    abstract fun initListener()
    abstract fun render(ui: UIModel)

}
