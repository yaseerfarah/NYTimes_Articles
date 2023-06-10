package com.yasser.nyarticles.modules.core.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yasser.nyarticles.modules.core.data.model.response.Media
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleEntity(
    val id: Long,
    val assetID: Long,
    val url: String,
    val source: String,
    val publishedDate: String,
    val section: String,
    val subsection: String,
    val byline: String,
    val type: String,
    val keywords: List<String>,
    val title: String,
    val abstract: String,
    val mediaImage: List<MediaImageEntity>,
):Parcelable
