package jp.room417.twitter4kt.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.*
import java.io.File
import java.io.InputStream

class TweetsResourcesImpl(private val twitter: Twitter) : TweetsResources {
    override suspend fun getRetweets(statusId: Long): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.getRetweets(statusId)
        }

    override suspend fun getRetweeterIds(
        statusId: Long,
        cursor: Long
    ): IDs = withContext(Dispatchers.IO) {
        twitter.getRetweeterIds(
            statusId,
            cursor
        )
    }

    override suspend fun getRetweeterIds(
        statusId: Long,
        count: Int,
        cursor: Long
    ): IDs = withContext(Dispatchers.IO) {
        twitter.getRetweeterIds(
            statusId,
            count,
            cursor
        )
    }

    override suspend fun showStatus(id: Long): Status = withContext(Dispatchers.IO) {
        twitter.showStatus(id)
    }

    override suspend fun destroyStatus(statusId: Long): Status = withContext(Dispatchers.IO) {
        twitter.destroyStatus(statusId)
    }

    override suspend fun updateStatus(status: String): Status = withContext(Dispatchers.IO) {
        twitter.updateStatus(status)
    }

    override suspend fun updateStatus(latestStatus: StatusUpdate): Status =
        withContext(Dispatchers.IO) {
            twitter.updateStatus(latestStatus)
        }

    override suspend fun retweetStatus(statusId: Long): Status = withContext(Dispatchers.IO) {
        twitter.retweetStatus(statusId)
    }

    override suspend fun unRetweetStatus(statusId: Long): Status = withContext(Dispatchers.IO) {
        twitter.unRetweetStatus(statusId)
    }

    override suspend fun getOEmbed(req: OEmbedRequest): OEmbed = withContext(Dispatchers.IO) {
        twitter.getOEmbed(req)
    }

    override suspend fun lookup(vararg ids: Long): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            twitter.lookup(*ids)
        }

    override suspend fun uploadMedia(mediaFile: File): UploadedMedia = withContext(Dispatchers.IO) {
        twitter.uploadMedia(mediaFile)
    }

    override suspend fun uploadMedia(
        fileName: String,
        media: InputStream
    ): UploadedMedia = withContext(Dispatchers.IO) {
        twitter.uploadMedia(
            fileName,
            media
        )
    }

    override suspend fun uploadMediaChunked(
        fileName: String,
        media: InputStream
    ): UploadedMedia = withContext(Dispatchers.IO) {
        twitter.uploadMediaChunked(
            fileName,
            media
        )
    }
}
