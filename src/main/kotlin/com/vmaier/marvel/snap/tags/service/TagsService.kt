package com.vmaier.marvel.snap.tags.service

import jakarta.transaction.Transactional
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
@Transactional
class TagsService(
    private val restTemplateService: RestTemplateService
) {

    private val logger = KotlinLogging.logger {}

    fun getCards() {
        val response = restTemplateService.getCards()
        if (response.statusCode == HttpStatus.OK) {
            val cards = response.body

        }
    }
}