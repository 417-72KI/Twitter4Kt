package jp.room417.twitter4kt.v1.api

import twitter4j.*
import java.io.File
import java.io.InputStream

/** A wrapper of [twitter4j.api.TweetsResources] */
interface TweetsResources {
    /** A wrapper of [twitter4j.api.TweetsResources.getRetweets] */
    @Throws(TwitterException::class)
    suspend fun getRetweets(statusId: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TweetsResources.getRetweeterIds] */
    @Throws(TwitterException::class)
    suspend fun getRetweeterIds(
        statusId: Long,
        cursor: Long
    ): IDs

    /** A wrapper of [twitter4j.api.TweetsResources.getRetweeterIds] */
    @Throws(TwitterException::class)
    suspend fun getRetweeterIds(
        statusId: Long,
        count: Int,
        cursor: Long
    ): IDs

    /** A wrapper of [twitter4j.api.TweetsResources.showStatus] */
    @Throws(TwitterException::class)
    suspend fun showStatus(id: Long): Status

    /** A wrapper of [twitter4j.api.TweetsResources.destroyStatus] */
    @Throws(TwitterException::class)
    suspend fun destroyStatus(statusId: Long): Status

    /** A wrapper of [twitter4j.api.TweetsResources.updateStatus] */
    @Throws(TwitterException::class)
    suspend fun updateStatus(status: String): Status

    /** A wrapper of [twitter4j.api.TweetsResources.updateStatus] */
    @Throws(TwitterException::class)
    suspend fun updateStatus(latestStatus: StatusUpdate): Status

    /** A wrapper of [twitter4j.api.TweetsResources.retweetStatus] */
    @Throws(TwitterException::class)
    suspend fun retweetStatus(statusId: Long): Status

    /** A wrapper of [twitter4j.api.TweetsResources.unRetweetStatus] */
    @Throws(TwitterException::class)
    suspend fun unRetweetStatus(statusId: Long): Status

    /** A wrapper of [twitter4j.api.TweetsResources.getOEmbed] */
    @Throws(TwitterException::class)
    suspend fun getOEmbed(req: OEmbedRequest): OEmbed

    /** A wrapper of [twitter4j.api.TweetsResources.lookup] */
    @Throws(TwitterException::class)
    suspend fun lookup(vararg ids: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.api.TweetsResources.uploadMedia] */
    @Throws(TwitterException::class)
    suspend fun uploadMedia(mediaFile: File): UploadedMedia

    /** A wrapper of [twitter4j.api.TweetsResources.uploadMedia] */
    @Throws(TwitterException::class)
    suspend fun uploadMedia(
        fileName: String,
        media: InputStream
    ): UploadedMedia

    /** A wrapper of [twitter4j.api.TweetsResources.uploadMediaChunked] */
    @Throws(TwitterException::class)
    suspend fun uploadMediaChunked(
        fileName: String,
        media: InputStream
    ): UploadedMedia
}
