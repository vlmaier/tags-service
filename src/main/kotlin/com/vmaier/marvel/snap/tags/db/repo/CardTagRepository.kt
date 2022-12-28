package com.vmaier.marvel.snap.tags.db.repo

import com.vmaier.marvel.snap.tags.db.dao.CardTag
import org.springframework.data.repository.CrudRepository

interface CardTagRepository : CrudRepository<CardTag, Int>