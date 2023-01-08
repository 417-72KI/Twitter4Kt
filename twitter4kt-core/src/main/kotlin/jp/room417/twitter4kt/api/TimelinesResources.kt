package jp.room417.twitter4kt.api

import twitter4j.Paging
import twitter4j.ResponseList
import twitter4j.Status
import twitter4j.TwitterException

/** A wrapper of [twitter4j.api.TimelinesResources] */
interface TimelinesResources {
    /** A wrapper of [twitter4j.api.TimelinesResources.getMentionsTimeline] */
    @Throws(TwitterException::class)
    suspend fun getMentionsTimeline(): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getMentionsTimeline] */
    @Throws(TwitterException::class)
    suspend fun getMentionsTimeline(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(screenName: String, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(userId: Long, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(screenName: String): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(userId: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getUserTimeline] */
    @Throws(TwitterException::class)
    suspend fun getUserTimeline(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getHomeTimeline] */
    @Throws(TwitterException::class)
    suspend fun getHomeTimeline(): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getHomeTimeline] */
    @Throws(TwitterException::class)
    suspend fun getHomeTimeline(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getRetweetsOfMe] */
    @Throws(TwitterException::class)
    suspend fun getRetweetsOfMe(): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TimelinesResources.getRetweetsOfMe] */
    @Throws(TwitterException::class)
    suspend fun getRetweetsOfMe(paging: Paging): ResponseList<Status>
}
