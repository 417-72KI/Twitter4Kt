package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.SpamReportingResource] */
interface SpamReportingResource {
    /** A wrapper of [twitter4j.v1.SpamReportingResource.reportSpam] */
    @Throws(TwitterException::class)
    suspend fun reportSpam(userId: Long): User

    /** A wrapper of [twitter4j.v1.SpamReportingResource.reportSpam] */
    @Throws(TwitterException::class)
    suspend fun reportSpam(screenName: String): User
}
