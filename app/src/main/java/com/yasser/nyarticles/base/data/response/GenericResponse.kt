package com.yasser.nyarticles.base.data.response

data class GenericResponse<T>(
    val status: String,
    val results: T)
