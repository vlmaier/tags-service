package com.vmaier.marvel.snap.tags.openapi.api

import com.vmaier.marvel.snap.tags.openapi.model.TagResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "tags")
@RequestMapping("/v1/tags", produces = ["application/json"])
interface TagsApi {

    @Operation(summary = "Create tags", description = "TODO ...")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "204", description = "No Content")
        ]
    )
    @PostMapping
    fun createTags(): ResponseEntity<Void>

    @Operation(summary = "List all available card tags", description = "TODO ...")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "OK", content = [
                    Content(array = ArraySchema(schema = Schema(implementation = TagResponse::class)))
                ]
            ),
        ]
    )
    @GetMapping
    fun listTags(): ResponseEntity<List<TagResponse>>
}