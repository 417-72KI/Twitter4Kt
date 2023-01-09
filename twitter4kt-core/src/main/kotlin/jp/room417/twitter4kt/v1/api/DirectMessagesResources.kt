package jp.room417.twitter4kt.v1.api

import twitter4j.*
import java.io.InputStream

/** A wrapper of [twitter4j.api.DirectMessagesResources] */
interface DirectMessagesResources {
    /** A wrapper of [twitter4j.api.DirectMessagesResources.getDirectMessages] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getDirectMessages(): ResponseList<DirectMessage>

    /** A wrapper of [twitter4j.api.DirectMessagesResources.getDirectMessages] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getDirectMessages(paging: Paging): ResponseList<DirectMessage>

    /** A wrapper of [twitter4j.api.DirectMessagesResources.getSentDirectMessages] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getSentDirectMessages(): ResponseList<DirectMessage>

    /** A wrapper of [twitter4j.api.DirectMessagesResources.getSentDirectMessages] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun getSentDirectMessages(paging: Paging): ResponseList<DirectMessage>

    /** A wrapper of [twitter4j.api.DirectMessagesResources.getDirectMessages] */
    @Throws(TwitterException::class)
    suspend fun getDirectMessages(count: Int): DirectMessageList

    /** A wrapper of [twitter4j.api.DirectMessagesResources.getDirectMessages] */
    @Throws(TwitterException::class)
    suspend fun getDirectMessages(count: Int, cursor: String): DirectMessageList

    /** A wrapper of [twitter4j.api.DirectMessagesResources.showDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun showDirectMessage(id: Long): DirectMessage

    /** A wrapper of [twitter4j.api.DirectMessagesResources.destroyDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun destroyDirectMessage(id: Long): DirectMessage

    /** A wrapper of [twitter4j.api.DirectMessagesResources.sendDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun sendDirectMessage(userId: Long, text: String): DirectMessage

    /** A wrapper of [twitter4j.api.DirectMessagesResources.sendDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun sendDirectMessage(userId: Long, text: String, mediaId: Long): DirectMessage

    /** A wrapper of [twitter4j.api.DirectMessagesResources.sendDirectMessage] */
    @Throws(TwitterException::class)
    suspend fun sendDirectMessage(screenName: String, text: String): DirectMessage

    /** A wrapper of [twitter4j.api.DirectMessagesResources.getDMImageAsStream] */
    @Throws(TwitterException::class)
    suspend fun getDMImageAsStream(url: String): InputStream
}
