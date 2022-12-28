package com.vmaier.marvel.snap.tags.model

data class CardResponse(
    val id: Int,
    val name: String,
    val cost: Int,
    val power: Int,
    val ability: String?,
    val series: String?,
    val imageUrl: String?
)