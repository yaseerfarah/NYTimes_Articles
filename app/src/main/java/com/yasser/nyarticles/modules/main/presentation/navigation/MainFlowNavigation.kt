package com.yasser.nyarticles.modules.main.presentation.navigation


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.yasser.nyarticles.R
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.details.presentation.view.DetailsFragment
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MainFlowNavigation @Inject constructor(){

    private lateinit var navController:NavController

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    fun backToHomeScreen(){
        navController.popBackStack()
    }
    fun navigateToDetailsScreen(articleEntity: ArticleEntity){
        val argument=Bundle()
        argument.putParcelable(DetailsFragment.DETAILS_PARAM,articleEntity)
        navController.navigate(R.id.action_homeFragment_to_detailsFragment,argument)
    }

    fun openArticleOnWebsite(activity: Context, url: String){
        val webpage = Uri.parse(url)
        val myIntent = Intent(Intent.ACTION_VIEW, webpage)
        activity.startActivity(myIntent)
    }

}