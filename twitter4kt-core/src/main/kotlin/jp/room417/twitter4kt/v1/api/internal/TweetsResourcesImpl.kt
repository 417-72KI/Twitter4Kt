package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.TweetsResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.*
import java.io.File
import java.io.InputStream

internal class TweetsResourcesImpl(private val tweets: twitter4j.v1.TweetsResources) : TweetsResources {
    override suspend fun getRetweets(statusId: Long): ResponseList<Status> = withContext(Dispatchers.IO) {
        tweets.getRetweets(statusId)
    }

    override suspend fun getRetweeterIds(
        statusId: Long,
        cursor: Long
    ): IDs = withContext(Dispatchers.IO) {
        tweets.getRetweeterIds(
            statusId,
            cursor
        )
    }

    override suspend fun getRetweeterIds(
        statusId: Long,
        count: Int,
        cursor: Long
    ): IDs = withContext(Dispatchers.IO) {
        tweets.getRetweeterIds(
            statusId,
            count,
            cursor
        )
    }

    override suspend fun showStatus(id: Long): Status = withContext(Dispatchers.IO) {
        tweets.showStatus(id)
    }

    override suspend fun destroyStatus(statusId: Long): Status = withContext(Dispatchers.IO) {
        tweets.destroyStatus(statusId)
    }

    override suspend fun updateStatus(status: String): Status = withContext(Dispatchers.IO) {
        tweets.updateStatus(status)
    }

    override suspend fun updateStatus(latestStatus: StatusUpdate): Status =
        withContext(Dispatchers.IO) {
            tweets.updateStatus(latestStatus)
        }

    override suspend fun retweetStatus(statusId: Long): Status = withContext(Dispatchers.IO) {
        tweets.retweetStatus(statusId)
    }

    override suspend fun unRetweetStatus(statusId: Long): Status = withContext(Dispatchers.IO) {
        tweets.unRetweetStatus(statusId)
    }

    override suspend fun getOEmbed(req: OEmbedRequest): OEmbed = withContext(Dispatchers.IO) {
        tweets.getOEmbed(req)
    }

    override suspend fun lookup(vararg ids: Long): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            tweets.lookup(*ids)
        }

    override suspend fun uploadMedia(mediaFile: File): UploadedMedia = withContext(Dispatchers.IO) {
        tweets.uploadMedia(mediaFile)
    }

    override suspend fun uploadMedia(
        fileName: String,
        media: InputStream
    ): UploadedMedia = withContext(Dispatchers.IO) {
        tweets.uploadMedia(
            fileName,
            media
        )
    }

    override suspend fun uploadMediaChunked(
        fileName: String,
        media: InputStream
    ): UploadedMedia = withContext(Dispatchers.IO) {
        tweets.uploadMediaChunked(
            fileName,
            media
        )
    }
}
