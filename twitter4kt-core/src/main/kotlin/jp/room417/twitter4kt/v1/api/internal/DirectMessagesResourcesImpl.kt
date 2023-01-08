@file:Suppress("DEPRECATION")

package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.DirectMessagesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.*
import twitter4j.v1.DirectMessage
import twitter4j.v1.DirectMessageList
import java.io.InputStream

internal class DirectMessagesResourcesImpl(private val directMessages: twitter4j.v1.DirectMessagesResources) : DirectMessagesResources {
    override suspend fun getDirectMessages(count: Int): DirectMessageList = withContext(Dispatchers.IO) {
        directMessages.getDirectMessages(count)
    }

    override suspend fun getDirectMessages(count: Int, cursor: String): DirectMessageList =
        withContext(Dispatchers.IO) {
            directMessages.getDirectMessages(count, cursor)
        }

    override suspend fun showDirectMessage(id: Long): DirectMessage = withContext(Dispatchers.IO) {
        directMessages.showDirectMessage(id)
    }

    override suspend fun destroyDirectMessage(id: Long) = withContext(Dispatchers.IO) {
        directMessages.destroyDirectMessage(id)
    }

    override suspend fun sendDirectMessage(userId: Long, text: String): DirectMessage = withContext(Dispatchers.IO) {
        directMessages.sendDirectMessage(userId, text)
    }

    override suspend fun sendDirectMessage(userId: Long, text: String, mediaId: Long): DirectMessage =
        withContext(Dispatchers.IO) {
            directMessages.sendDirectMessage(userId, text, mediaId)
        }

    override suspend fun sendDirectMessage(screenName: String, text: String): DirectMessage =
        withContext(Dispatchers.IO) {
            directMessages.sendDirectMessage(screenName, text)
        }

    override suspend fun getDMImageAsStream(url: String): InputStream = withContext(Dispatchers.IO) {
        directMessages.getDMImageAsStream(url)
    }
}
