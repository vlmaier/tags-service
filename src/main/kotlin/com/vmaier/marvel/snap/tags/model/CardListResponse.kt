package com.vmaier.marvel.snap.tags.model

data class CardListResponse(
    val total: Int,
    val cards: List<CardResponse>
)