package com.yasser.nyarticles.modules.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaImageEntity(
    val caption: String,
    val copyright: String,
    val listOfImage:List<String>
):Parcelable
