@file:Suppress("DEPRECATION")

package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.DirectMessagesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.*
import java.io.InputStream

internal class DirectMessagesResourcesImpl(private val twitter: Twitter) : DirectMessagesResources {
    override suspend fun getDirectMessages(): ResponseList<DirectMessage> = withContext(Dispatchers.IO) {
        twitter.directMessages
    }

    override suspend fun getDirectMessages(paging: Paging): ResponseList<DirectMessage> = withContext(Dispatchers.IO) {
        twitter.directMessages
    }

    override suspend fun getSentDirectMessages(): ResponseList<DirectMessage> = withContext(Dispatchers.IO) {
        twitter.sentDirectMessages
    }

    override suspend fun getSentDirectMessages(paging: Paging): ResponseList<DirectMessage> =
        withContext(Dispatchers.IO) {
            twitter.getSentDirectMessages(paging)
        }

    override suspend fun getDirectMessages(count: Int): DirectMessageList = withContext(Dispatchers.IO) {
        twitter.getDirectMessages(count)
    }

    override suspend fun getDirectMessages(count: Int, cursor: String): DirectMessageList =
        withContext(Dispatchers.IO) {
            twitter.getDirectMessages(count, cursor)
        }

    override suspend fun showDirectMessage(id: Long): DirectMessage = withContext(Dispatchers.IO) {
        twitter.showDirectMessage(id)
    }

    override suspend fun destroyDirectMessage(id: Long): DirectMessage = withContext(Dispatchers.IO) {
        twitter.destroyDirectMessage(id)
    }

    override suspend fun sendDirectMessage(userId: Long, text: String): DirectMessage = withContext(Dispatchers.IO) {
        twitter.sendDirectMessage(userId, text)
    }

    override suspend fun sendDirectMessage(userId: Long, text: String, mediaId: Long): DirectMessage =
        withContext(Dispatchers.IO) {
            twitter.sendDirectMessage(userId, text, mediaId)
        }

    override suspend fun sendDirectMessage(screenName: String, text: String): DirectMessage =
        withContext(Dispatchers.IO) {
            twitter.sendDirectMessage(screenName, text)
        }

    override suspend fun getDMImageAsStream(url: String): InputStream = withContext(Dispatchers.IO) {
        twitter.getDMImageAsStream(url)
    }
}
