package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*
import java.io.InputStream

/** A wrapper of [twitter4j.v1.DirectMessagesResources] */
interface DirectMessagesResources {
    /** A wrapper of [twitter4j.v1.DirectMessagesResources.getDirectMessages] */
    @Throws(TwitterException::class)
    suspend fun getDirectMessages(count: Int): DirectMessageList

    /** A wrapper of [twitter4j.v1.DirectMessagesResources.getDirectMessages] */
    @Throws(TwitterException::class)
    suspend fun getDirectMessages(count: Int, cursor: String): DirectMessageList

    /** A wrapper of [twitter4j.v1.DirectMessagesResources.showDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun showDirectMessage(id: Long): DirectMessage

    /** A wrapper of [twitter4j.v1.DirectMessagesResources.destroyDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun destroyDirectMessage(id: Long)

    /** A wrapper of [twitter4j.v1.DirectMessagesResources.sendDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun sendDirectMessage(userId: Long, text: String): DirectMessage

    /** A wrapper of [twitter4j.v1.DirectMessagesResources.sendDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun sendDirectMessage(userId: Long, text: String, mediaId: Long): DirectMessage

    /** A wrapper of [twitter4j.v1.DirectMessagesResources.sendDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun sendDirectMessage(screenName: String, text: String): DirectMessage

    /** A wrapper of [twitter4j.v1.DirectMessagesResources.getDMImageAsStream] */
    @Throws(TwitterException::class)
    suspend fun getDMImageAsStream(url: String): InputStream
}
