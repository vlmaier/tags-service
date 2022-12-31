package com.vmaier.marvel.snap.tags.service

import com.vmaier.marvel.snap.tags.CardsServiceConfig
import com.vmaier.marvel.snap.tags.model.CardListResponse
import com.vmaier.marvel.snap.tags.model.CardResponse
import mu.KotlinLogging
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

    fun getCards(): List<CardResponse> {
        val cards = mutableListOf<CardResponse>()
        try {
            var total = Int.MAX_VALUE
            var page = 0
            val size = 20
            while (total > page * size) {
                val entity = restTemplate.getForEntity(
                    UriComponentsBuilder
                        .fromHttpUrl(cardsServiceConfig.url)
                        .path("/cards")
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .build()
                        .toUri(),
                    CardListResponse::class.java
                )
                if (entity.body != null) {
                    cards.addAll(entity.body!!.cards)
                    total = entity.body!!.total
                    page++
                }
            }
        } catch (e: RestClientResponseException) {
            logger.error { "Error occurred: ${e.message}" }
        }
        return cards
    }
}