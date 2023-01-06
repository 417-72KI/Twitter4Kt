package jp.room417.twitter4kt.api.internal

import jp.room417.twitter4kt.api.SpamReportingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.Twitter
import twitter4j.User

internal class SpamReportingResourceImpl(private val twitter: Twitter) : SpamReportingResource {
    override suspend fun reportSpam(userId: Long): User = withContext(Dispatchers.IO) {
        twitter.reportSpam(userId)
    }

    override suspend fun reportSpam(screenName: String): User = withContext(Dispatchers.IO) {
        twitter.reportSpam(screenName)
    }
}
