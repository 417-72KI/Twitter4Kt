package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.FriendsFollowersResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.*

internal class FriendsFollowersResourcesImpl(private val friendsFollowers: twitter4j.v1.FriendsFollowersResources) : FriendsFollowersResources {
    override suspend fun getNoRetweetsFriendships(): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.noRetweetsFriendships
    }

    override suspend fun getFriendsIDs(cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFriendsIDs(cursor)
    }

    override suspend fun getFriendsIDs(userId: Long, cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFriendsIDs(userId, cursor)
    }

    override suspend fun getFriendsIDs(userId: Long, cursor: Long, count: Int): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFriendsIDs(userId, cursor, count)
    }

    override suspend fun getFriendsIDs(screenName: String, cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFriendsIDs(screenName, cursor)
    }

    override suspend fun getFriendsIDs(screenName: String, cursor: Long, count: Int): IDs =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFriendsIDs(screenName, cursor, count)
        }

    override suspend fun getFollowersIDs(cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFollowersIDs(cursor)
    }

    override suspend fun getFollowersIDs(userId: Long, cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFollowersIDs(userId, cursor)
    }

    override suspend fun getFollowersIDs(userId: Long, cursor: Long, count: Int): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFollowersIDs(userId, cursor, count)
    }

    override suspend fun getFollowersIDs(screenName: String, cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getFollowersIDs(screenName, cursor)
    }

    override suspend fun getFollowersIDs(screenName: String, cursor: Long, count: Int): IDs =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFollowersIDs(screenName, cursor, count)
        }

    override suspend fun lookupFriendships(vararg ids: Long): ResponseList<Friendship> = withContext(Dispatchers.IO) {
        friendsFollowers.lookupFriendships(*ids)
    }

    override suspend fun lookupFriendships(vararg screenNames: String): ResponseList<Friendship> =
        withContext(Dispatchers.IO) {
            friendsFollowers.lookupFriendships(*screenNames)
        }

    override suspend fun getIncomingFriendships(cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getIncomingFriendships(cursor)
    }

    override suspend fun getOutgoingFriendships(cursor: Long): IDs = withContext(Dispatchers.IO) {
        friendsFollowers.getOutgoingFriendships(cursor)
    }

    override suspend fun createFriendship(userId: Long): User = withContext(Dispatchers.IO) {
        friendsFollowers.createFriendship(userId)
    }

    override suspend fun createFriendship(screenName: String): User = withContext(Dispatchers.IO) {
        friendsFollowers.createFriendship(screenName)
    }

    override suspend fun createFriendship(userId: Long, follow: Boolean): User = withContext(Dispatchers.IO) {
        friendsFollowers.createFriendship(userId, follow)
    }

    override suspend fun createFriendship(screenName: String, follow: Boolean): User = withContext(Dispatchers.IO) {
        friendsFollowers.createFriendship(screenName, follow)
    }

    override suspend fun destroyFriendship(userId: Long): User = withContext(Dispatchers.IO) {
        friendsFollowers.destroyFriendship(userId)
    }

    override suspend fun destroyFriendship(screenName: String): User = withContext(Dispatchers.IO) {
        friendsFollowers.destroyFriendship(screenName)
    }

    override suspend fun updateFriendship(
        userId: Long,
        enableDeviceNotification: Boolean,
        retweets: Boolean
    ): Relationship = withContext(Dispatchers.IO) {
        friendsFollowers.updateFriendship(userId, enableDeviceNotification, retweets)
    }

    override suspend fun updateFriendship(
        screenName: String,
        enableDeviceNotification: Boolean,
        retweets: Boolean
    ): Relationship = withContext(Dispatchers.IO) {
        friendsFollowers.updateFriendship(screenName, enableDeviceNotification, retweets)
    }

    override suspend fun showFriendship(sourceId: Long, targetId: Long): Relationship = withContext(Dispatchers.IO) {
        friendsFollowers.showFriendship(sourceId, targetId)
    }

    override suspend fun showFriendship(sourceScreenName: String, targetScreenName: String): Relationship =
        withContext(Dispatchers.IO) {
            friendsFollowers.showFriendship(sourceScreenName, targetScreenName)
        }

    override suspend fun getFriendsList(userId: Long, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFriendsList(userId, cursor)
        }

    override suspend fun getFriendsList(userId: Long, cursor: Long, count: Int): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFriendsList(userId, cursor, count)
        }

    override suspend fun getFriendsList(screenName: String, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFriendsList(screenName, cursor)
        }

    override suspend fun getFriendsList(screenName: String, cursor: Long, count: Int): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFriendsList(screenName, cursor, count)
        }

    override suspend fun getFriendsList(
        userId: Long,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        friendsFollowers.getFriendsList(userId, cursor, count, skipStatus, includeUserEntities)
    }

    override suspend fun getFriendsList(
        screenName: String,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        friendsFollowers.getFriendsList(screenName, cursor, count, skipStatus, includeUserEntities)
    }

    override suspend fun getFollowersList(userId: Long, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFollowersList(userId, cursor)
        }

    override suspend fun getFollowersList(screenName: String, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFollowersList(screenName, cursor)
        }

    override suspend fun getFollowersList(userId: Long, cursor: Long, count: Int): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFollowersList(userId, cursor, count)
        }

    override suspend fun getFollowersList(screenName: String, cursor: Long, count: Int): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            friendsFollowers.getFollowersList(screenName, cursor, count)
        }

    override suspend fun getFollowersList(
        userId: Long,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        friendsFollowers.getFollowersList(userId, cursor, count, skipStatus, includeUserEntities)
    }

    override suspend fun getFollowersList(
        screenName: String,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        friendsFollowers.getFollowersList(screenName, cursor, count, skipStatus, includeUserEntities)
    }
}
