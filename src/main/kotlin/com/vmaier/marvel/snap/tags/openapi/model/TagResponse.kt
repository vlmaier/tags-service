package com.vmaier.marvel.snap.tags.openapi.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Model for displaying information of a card tag")
data class TagResponse(

    @field:Schema(description = "Tag name")
    val tagName: String,

    @field:Schema(description = "Name of the character")
    val cardName: String
)