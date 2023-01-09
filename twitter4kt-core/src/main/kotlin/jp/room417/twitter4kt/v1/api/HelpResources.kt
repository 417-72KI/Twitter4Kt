package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*
import twitter4j.v1.HelpResources.Language

/** A wrapper of [twitter4j.v1.HelpResources] */
interface HelpResources {
    /** A wrapper of [twitter4j.v1.HelpResources.getLanguages] */
    @Throws(TwitterException::class)
    suspend fun getLanguages(): ResponseList<Language>

    /** A wrapper of [twitter4j.v1.HelpResources.getRateLimitStatus] */
    @Throws(TwitterException::class)
    suspend fun getRateLimitStatus(): Map<String, RateLimitStatus>

    /** A wrapper of [twitter4j.v1.HelpResources.getRateLimitStatus] */
    @Throws(TwitterException::class)
    suspend fun getRateLimitStatus(vararg resources: String): Map<String, RateLimitStatus>
}
