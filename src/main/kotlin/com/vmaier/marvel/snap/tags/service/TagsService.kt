package com.vmaier.marvel.snap.tags.service

import com.vmaier.marvel.snap.tags.db.dao.CardTag
import com.vmaier.marvel.snap.tags.db.repo.CardTagRepository
import com.vmaier.marvel.snap.tags.db.repo.TagRepository
import com.vmaier.marvel.snap.tags.model.CardResponse
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Stream

@Service
@Transactional
class TagsService(
    private val restTemplateService: RestTemplateService,
    private val tagRepository: TagRepository,
    private val cardTagRepository: CardTagRepository
) {

    fun createTags() {
        val cards = getCards()
        val cardTags = mutableListOf<CardTag>()
        for (card in cards.toList()) {
            val tags = findTags(card)
            for (tag in tags) {
                cardTags.add(CardTag(tag.key, card.name))
            }
        }
        cardTagRepository.saveAll(cardTags)
    }

    fun getCards(): List<CardResponse> {
        val response = restTemplateService.getCards()
        if (response.statusCode == HttpStatus.OK) {
            val cards = response.body
            if (!cards.isNullOrEmpty()) {
                return cards.toList()
            }
        }
        return listOf()
    }

    fun findTags(card: CardResponse): Map<Int, String> {
        val tags = mutableMapOf<Int, String>()
        findTag(card, tags, "On Reveal", "On Reveal:")
        findTag(card, tags, "Ongoing", "Ongoing:")
        findTag(card, tags, "Move", "Move")
        findTag(card, tags, "Add Card", "Add", "Card")
        findTag(card, tags, "Destroy", "Destroy")
        // findTag(card, tags, "Stack Power", "")
        findTag(card, tags, "Discard", "Discard")
        findTag(card, tags, "Draw Card", "Draw", "Card")
        // findTag(card, tags, "Manipulate Power", "")
        // findTag(card, tags, "Manipulate Cost", "")
        // findTag(card, tags, "Conditional", "")
        // findTag(card, tags, "No Ability", "")
        return tags
    }

    fun findTag(card: CardResponse, tags: MutableMap<Int, String>, tagName: String, vararg keywords: String) {
        val allTags = tagRepository.findAll()
        if (card.ability.isNullOrEmpty()) {
            return
        }
        val abilityWordList = card.ability.split(" ").toList()
        if (keywords.asList().stream().allMatch(abilityWordList::contains)) {
            val tagId = allTags.find { t -> t.name == tagName }?.id ?: 0
            if (tagId == 0) {
                return
            }
            tags[tagId] = card.name
        }
    }
}