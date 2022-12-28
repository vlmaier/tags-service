package com.vmaier.marvel.snap.tags.service

import com.vmaier.marvel.snap.tags.CardsServiceConfig
import com.vmaier.marvel.snap.tags.model.CardResponse
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClientResponseException
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class RestTemplateService(
    private val restTemplate: RestTemplate,
    private val cardsServiceConfig: CardsServiceConfig
) {

    private var logger = KotlinLogging.logger {}

    fun getCards(): ResponseEntity<Array<CardResponse>> = try {
        restTemplate.getForEntity(
            UriComponentsBuilder
                .fromHttpUrl(cardsServiceConfig.url)
                .path("/cards")
                .build()
                .toUri(),
            Array<CardResponse>::class.java
        )
    } catch (e: RestClientResponseException) {
        logger.error { "Error occurred: ${e.message}" }
        ResponseEntity.status(e.statusCode).build()
    }
}