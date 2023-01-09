package jp.room417.twitter4kt.v1.api

import twitter4j.RateLimitStatus
import twitter4j.ResponseList
import twitter4j.TwitterAPIConfiguration
import twitter4j.TwitterException
import twitter4j.api.HelpResources.Language

/** A wrapper of [twitter4j.api.HelpResources] */
interface HelpResources {
    /** A wrapper of [twitter4j.api.HelpResources.getAPIConfiguration] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getAPIConfiguration(): TwitterAPIConfiguration

    /** A wrapper of [twitter4j.api.HelpResources.getLanguages] */
    @Throws(TwitterException::class)
    suspend fun getLanguages(): ResponseList<Language>

    /** A wrapper of [twitter4j.api.HelpResources.getPrivacyPolicy] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getPrivacyPolicy(): String

    /** A wrapper of [twitter4j.api.HelpResources.getTermsOfService] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getTermsOfService(): String

    /** A wrapper of [twitter4j.api.HelpResources.getRateLimitStatus] */
    @Throws(TwitterException::class)
    suspend fun getRateLimitStatus(): Map<String, RateLimitStatus>

    /** A wrapper of [twitter4j.api.HelpResources.getRateLimitStatus] */
    @Throws(TwitterException::class)
    suspend fun getRateLimitStatus(vararg resources: String): Map<String, RateLimitStatus>
}
