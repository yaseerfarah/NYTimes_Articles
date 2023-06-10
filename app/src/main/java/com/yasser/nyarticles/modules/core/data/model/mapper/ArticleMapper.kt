package com.yasser.nyarticles.modules.core.data.model.mapper

import com.yasser.nyarticles.modules.core.data.model.response.ArticleResponse
import com.yasser.nyarticles.modules.core.data.model.response.Media
import com.yasser.nyarticles.modules.core.domain.entity.ArticleEntity
import com.yasser.nyarticles.modules.core.domain.entity.MediaImageEntity


fun List<ArticleResponse>.toListOfArticleEntity():List<ArticleEntity>{
    return this.map { articleResponse->
        articleResponse.toArticleEntity()
    }
}



fun ArticleResponse.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
         id= id,
         assetID= assetID,
         url= url,
         source= source,
         publishedDate= publishedDate,
         section= section,
         subsection= subsection,
         byline= byline,
         type=type ,
         keywords= keywords.split(";"),
         title= title,
         abstract= abstract,
         mediaImage= media.toListOfMediaImageEntity(),
    )
}


fun List<Media>.toListOfMediaImageEntity():List<MediaImageEntity>{
    return this.map { media->
        MediaImageEntity(
            caption = media.caption,
            copyright = media.copyright,
            listOfImage = media.mediaMetadata.map { it.url }
        )
    }
}