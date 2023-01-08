package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*
import java.io.File
import java.io.InputStream

/** A wrapper of [twitter4j.v1.TweetsResources] */
interface TweetsResources {
    /** A wrapper of [twitter4j.v1.TweetsResources.getRetweets] */
    @Throws(TwitterException::class)
    suspend fun getRetweets(statusId: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TweetsResources.getRetweeterIds] */
    @Throws(TwitterException::class)
    suspend fun getRetweeterIds(
        statusId: Long,
        cursor: Long
    ): IDs

    /** A wrapper of [twitter4j.v1.TweetsResources.getRetweeterIds] */
    @Throws(TwitterException::class)
    suspend fun getRetweeterIds(
        statusId: Long,
        count: Int,
        cursor: Long
    ): IDs

    /** A wrapper of [twitter4j.v1.TweetsResources.showStatus] */
    @Throws(TwitterException::class)
    suspend fun showStatus(id: Long): Status

    /** A wrapper of [twitter4j.v1.TweetsResources.destroyStatus] */
    @Throws(TwitterException::class)
    suspend fun destroyStatus(statusId: Long): Status

    /** A wrapper of [twitter4j.v1.TweetsResources.updateStatus] */
    @Throws(TwitterException::class)
    suspend fun updateStatus(status: String): Status

    /** A wrapper of [twitter4j.v1.TweetsResources.updateStatus] */
    @Throws(TwitterException::class)
    suspend fun updateStatus(latestStatus: StatusUpdate): Status

    /** A wrapper of [twitter4j.v1.TweetsResources.retweetStatus] */
    @Throws(TwitterException::class)
    suspend fun retweetStatus(statusId: Long): Status

    /** A wrapper of [twitter4j.v1.TweetsResources.unRetweetStatus] */
    @Throws(TwitterException::class)
    suspend fun unRetweetStatus(statusId: Long): Status

    /** A wrapper of [twitter4j.v1.TweetsResources.getOEmbed] */
    @Throws(TwitterException::class)
    suspend fun getOEmbed(req: OEmbedRequest): OEmbed

    /** A wrapper of [twitter4j.v1.TweetsResources.lookup] */
    @Throws(TwitterException::class)
    suspend fun lookup(vararg ids: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.TweetsResources.uploadMedia] */
    @Throws(TwitterException::class)
    suspend fun uploadMedia(mediaFile: File): UploadedMedia

    /** A wrapper of [twitter4j.v1.TweetsResources.uploadMedia] */
    @Throws(TwitterException::class)
    suspend fun uploadMedia(
        fileName: String,
        media: InputStream
    ): UploadedMedia

    /** A wrapper of [twitter4j.v1.TweetsResources.uploadMediaChunked] */
    @Throws(TwitterException::class)
    suspend fun uploadMediaChunked(
        fileName: String,
        media: InputStream
    ): UploadedMedia
}
