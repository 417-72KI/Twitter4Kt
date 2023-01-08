package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.TimelinesResources] */
interface TimelinesResources {
    /** A wrapper of [twitter4j.v1.TimelinesResources.getMentionsTimeline] */
    @Throws(TwitterException::class)
    suspend fun getMentionsTimeline(): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getMentionsTimeline] */
    @Throws(TwitterException::class)
    suspend fun getMentionsTimeline(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(screenName: String, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(userId: Long, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(screenName: String): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(userId: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getHomeTimeline] */
    @Throws(TwitterException::class)
    suspend fun getHomeTimeline(): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getHomeTimeline] */
    @Throws(TwitterException::class)
    suspend fun getHomeTimeline(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getRetweetsOfMe] */
    @Throws(TwitterException::class)
    suspend fun getRetweetsOfMe(): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TimelinesResources.getRetweetsOfMe] */
    @Throws(TwitterException::class)
    suspend fun getRetweetsOfMe(paging: Paging): ResponseList<Status>
}
