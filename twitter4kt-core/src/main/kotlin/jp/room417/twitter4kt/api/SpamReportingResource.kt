package jp.room417.twitter4kt.api

import twitter4j.TwitterException
import twitter4j.User

/** A wrapper of [twitter4j.api.SpamReportingResource] */
interface SpamReportingResource {
    /** A wrapper of [twitter4j.api.SpamReportingResource.reportSpam] */
    @Throws(TwitterException::class)
    suspend fun reportSpam(userId: Long): User

    /** A wrapper of [twitter4j.api.SpamReportingResource.reportSpam] */
    @Throws(TwitterException::class)
    suspend fun reportSpam(screenName: String): User
}
