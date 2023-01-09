package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.HelpResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.HelpResources.Language
import twitter4j.v1.RateLimitStatus
import twitter4j.v1.ResponseList

internal class HelpResourcesImpl(private val help: twitter4j.v1.HelpResources) : HelpResources {
    override suspend fun getLanguages(): ResponseList<Language> = withContext(Dispatchers.IO) {
        help.languages
    }

    override suspend fun getRateLimitStatus(): Map<String, RateLimitStatus> = withContext(Dispatchers.IO) {
        help.rateLimitStatus
    }

    override suspend fun getRateLimitStatus(vararg resources: String): Map<String, RateLimitStatus> =
        withContext(Dispatchers.IO) {
            help.getRateLimitStatus(*resources)
        }
}
