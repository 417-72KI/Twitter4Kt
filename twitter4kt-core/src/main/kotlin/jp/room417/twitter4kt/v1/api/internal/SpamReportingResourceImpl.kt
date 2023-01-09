package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.SpamReportingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.User

internal class SpamReportingResourceImpl(private val spamReporting: twitter4j.v1.SpamReportingResource) : SpamReportingResource {
    override suspend fun reportSpam(userId: Long): User = withContext(Dispatchers.IO) {
        spamReporting.reportSpam(userId)
    }

    override suspend fun reportSpam(screenName: String): User = withContext(Dispatchers.IO) {
        spamReporting.reportSpam(screenName)
    }
}
