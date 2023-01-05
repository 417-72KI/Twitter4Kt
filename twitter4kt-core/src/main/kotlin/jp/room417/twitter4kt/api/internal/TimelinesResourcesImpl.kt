package jp.room417.twitter4kt.api.internal

import jp.room417.twitter4kt.api.TimelinesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.Paging
import twitter4j.ResponseList
import twitter4j.Status
import twitter4j.Twitter

internal class TimelinesResourcesImpl(private val twitter: Twitter) : TimelinesResources {
    override suspend fun getMentionsTimeline(): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.mentionsTimeline
        }

    override suspend fun getMentionsTimeline(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getMentionsTimeline(paging)
        }

    override suspend fun getUserTimeline(
        screenName: String?,
        paging: Paging
    ): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getUserTimeline(screenName, paging)
        }

    override suspend fun getUserTimeline(userId: Long, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getUserTimeline(userId, paging)
        }

    override suspend fun getUserTimeline(screenName: String?): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getUserTimeline(screenName)
        }

    override suspend fun getUserTimeline(userId: Long): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getUserTimeline(userId)
        }

    override suspend fun getUserTimeline(): ResponseList<Status> = withContext(Dispatchers.IO) {
        twitter.userTimeline
    }

    override suspend fun getUserTimeline(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getUserTimeline(paging)
        }

    override suspend fun getHomeTimeline(): ResponseList<Status> = withContext(Dispatchers.IO) {
        twitter.homeTimeline
    }

    override suspend fun getHomeTimeline(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getHomeTimeline(paging)
        }

    override suspend fun getRetweetsOfMe(): ResponseList<Status> = withContext(Dispatchers.IO) {
        twitter.retweetsOfMe
    }

    override suspend fun getRetweetsOfMe(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getRetweetsOfMe(paging)
        }
}
