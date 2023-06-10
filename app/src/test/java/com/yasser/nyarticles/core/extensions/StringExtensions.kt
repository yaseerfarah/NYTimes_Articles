package com.yasser.nyarticles.core.extensions

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class StringExtensions {


    @Test
    fun `convert string date to actual format date `(){
        val unformatDate="2023-06-08"
        val formatDate=unformatDate.convertToDate()?.convertToUiDate()
        assertThat(formatDate).isEqualTo("08/06/2023")
    }


}