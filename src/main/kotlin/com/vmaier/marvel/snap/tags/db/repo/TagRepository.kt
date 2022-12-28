package com.vmaier.marvel.snap.tags.db.repo

import com.vmaier.marvel.snap.tags.db.dao.Tag
import org.springframework.data.repository.CrudRepository

interface TagRepository : CrudRepository<Tag, Int>