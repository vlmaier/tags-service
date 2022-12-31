package com.vmaier.marvel.snap.tags.controller

import com.vmaier.marvel.snap.tags.openapi.api.TagsApi
import com.vmaier.marvel.snap.tags.openapi.model.TagResponse
import com.vmaier.marvel.snap.tags.service.TagsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TagsController constructor(private val tagsService: TagsService): TagsApi {

    override fun createTags(): ResponseEntity<Void> {
        tagsService.createTags()
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    override fun listTags(): ResponseEntity<List<TagResponse>> {
        val tags = tagsService.getAllTags()
        val cardTags = tagsService.getAllCardTags()
        val response = mutableListOf<TagResponse>()
        for (cardTag in cardTags) {
            response.add(TagResponse(tags[cardTag.tagId]!!, cardTag.cardName))
        }
        return ResponseEntity<List<TagResponse>>(response, HttpStatus.OK)
    }
}