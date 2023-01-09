package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.HelpResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.RateLimitStatus
import twitter4j.ResponseList
import twitter4j.Twitter
import twitter4j.TwitterAPIConfiguration
import twitter4j.api.HelpResources.Language

internal class HelpResourcesImpl(private val twitter: Twitter) : HelpResources {
    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember")
    override suspend fun getAPIConfiguration(): TwitterAPIConfiguration = withContext(Dispatchers.IO) {
        twitter.apiConfiguration
    }

    override suspend fun getLanguages(): ResponseList<Language> = withContext(Dispatchers.IO) {
        twitter.languages
    }

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember")
    override suspend fun getPrivacyPolicy(): String = withContext(Dispatchers.IO) {
        twitter.privacyPolicy
    }

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember")
    override suspend fun getTermsOfService(): String = withContext(Dispatchers.IO) {
        twitter.termsOfService
    }

    override suspend fun getRateLimitStatus(): Map<String, RateLimitStatus> = withContext(Dispatchers.IO) {
        twitter.rateLimitStatus
    }

    override suspend fun getRateLimitStatus(vararg resources: String): Map<String, RateLimitStatus> =
        withContext(Dispatchers.IO) {
            twitter.getRateLimitStatus(*resources)
        }
}
