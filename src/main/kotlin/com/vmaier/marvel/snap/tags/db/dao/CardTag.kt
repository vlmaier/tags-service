package com.vmaier.marvel.snap.tags.db.dao

import jakarta.persistence.*

@Table(name = "card_tags")
@Entity
data class CardTag (
    val tagId: Int,
    val cardName: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
)