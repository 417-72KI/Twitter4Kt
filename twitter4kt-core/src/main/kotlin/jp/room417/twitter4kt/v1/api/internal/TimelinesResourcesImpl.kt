package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.TimelinesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.Paging
import twitter4j.v1.ResponseList
import twitter4j.v1.Status

internal class TimelinesResourcesImpl(private val timelines: twitter4j.v1.TimelinesResources) : TimelinesResources {
    override suspend fun getMentionsTimeline(): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.mentionsTimeline
        }

    override suspend fun getMentionsTimeline(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getMentionsTimeline(paging)
        }

    override suspend fun getUserTimeline(
        screenName: String,
        paging: Paging
    ): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getUserTimeline(screenName, paging)
        }

    override suspend fun getUserTimeline(userId: Long, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getUserTimeline(userId, paging)
        }

    override suspend fun getUserTimeline(screenName: String): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getUserTimeline(screenName)
        }

    override suspend fun getUserTimeline(userId: Long): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getUserTimeline(userId)
        }

    override suspend fun getUserTimeline(): ResponseList<Status> = withContext(Dispatchers.IO) {
        timelines.userTimeline
    }

    override suspend fun getUserTimeline(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getUserTimeline(paging)
        }

    override suspend fun getHomeTimeline(): ResponseList<Status> = withContext(Dispatchers.IO) {
        timelines.homeTimeline
    }

    override suspend fun getHomeTimeline(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getHomeTimeline(paging)
        }

    override suspend fun getRetweetsOfMe(): ResponseList<Status> = withContext(Dispatchers.IO) {
        timelines.retweetsOfMe
    }

    override suspend fun getRetweetsOfMe(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            timelines.getRetweetsOfMe(paging)
        }
}
