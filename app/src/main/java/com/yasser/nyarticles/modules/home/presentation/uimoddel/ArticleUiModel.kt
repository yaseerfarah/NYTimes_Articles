package com.yasser.nyarticles.modules.home.presentation.uimoddel

import androidx.recyclerview.widget.DiffUtil
import com.yasser.nyarticles.modules.core.domain.entity.MediaImageEntity

data class ArticleUiModel(
    val id: Long,
    val source: String,
    val publishedDate: String,
    val section: String,
    val byline: String,
    val title: String,
    val abstract: String,
    val imageUrl: String,
){

    fun areContentSame(oldModel:ArticleUiModel):Boolean{
        return id == oldModel.id
                && source == oldModel.source
                && publishedDate == oldModel.publishedDate
                && section == oldModel.section
                && byline == oldModel.byline
                && title == oldModel.title
                && abstract == oldModel.abstract
                && imageUrl == oldModel.imageUrl
    }

}


object ArticleDiffUtils: DiffUtil.ItemCallback<ArticleUiModel>(){
    override fun areItemsTheSame(oldItem: ArticleUiModel, newItem: ArticleUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ArticleUiModel, newItem: ArticleUiModel): Boolean {
        return newItem.areContentSame(oldItem)
    }

}
