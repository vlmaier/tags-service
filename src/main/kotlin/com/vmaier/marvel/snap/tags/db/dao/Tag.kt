package com.vmaier.marvel.snap.tags.db.dao

import jakarta.persistence.*

@Table(name = "tags")
@Entity
data class Tag (
    val name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
)