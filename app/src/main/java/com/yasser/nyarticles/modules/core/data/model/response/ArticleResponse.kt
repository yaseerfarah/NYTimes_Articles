package com.yasser.nyarticles.modules.core.data.model.response

import com.google.gson.annotations.SerializedName


data class ArticleResponse(
    val id: Long,
    @SerializedName("asset_id")
    val assetID: Long,
    val url: String,
    val source: String,
    @SerializedName("published_date")
    val publishedDate: String,
    val section: String,
    val subsection: String,
    val byline: String,
    val type: String,
    @SerializedName("adx_keywords")
    val keywords: String,
    val title: String,
    val abstract: String,
    val media: List<Media>,
)


data class Media (
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetaData>
)

data class MediaMetaData (
    val url: String,
    val format: String,
    val height: Long,
    val width: Long
)

