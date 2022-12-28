package com.vmaier.marvel.snap.tags

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "cards-service")
class CardsServiceConfig {
    var url: String = ""
}