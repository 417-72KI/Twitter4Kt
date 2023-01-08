package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.FriendsFollowersResources] */
interface FriendsFollowersResources {
    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getNoRetweetsFriendships] */
    @Throws(TwitterException::class)
    suspend fun getNoRetweetsFriendships(): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsIDs] */
    @Throws(TwitterException::class)
    suspend fun getFriendsIDs(cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsIDs] */
    @Throws(TwitterException::class)
    suspend fun getFriendsIDs(userId: Long, cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsIDs] */
    @Throws(TwitterException::class)
    suspend fun getFriendsIDs(userId: Long, cursor: Long, count: Int): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsIDs] */
    @Throws(TwitterException::class)
    suspend fun getFriendsIDs(screenName: String, cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsIDs] */
    @Throws(TwitterException::class)
    suspend fun getFriendsIDs(screenName: String, cursor: Long, count: Int): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersIDs] */
    @Throws(TwitterException::class)
    suspend fun getFollowersIDs(cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersIDs] */
    @Throws(TwitterException::class)
    suspend fun getFollowersIDs(userId: Long, cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersIDs] */
    @Throws(TwitterException::class)
    suspend fun getFollowersIDs(userId: Long, cursor: Long, count: Int): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersIDs] */
    @Throws(TwitterException::class)
    suspend fun getFollowersIDs(screenName: String, cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersIDs] */
    @Throws(TwitterException::class)
    suspend fun getFollowersIDs(screenName: String, cursor: Long, count: Int): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.lookupFriendships] */
    @Throws(TwitterException::class)
    suspend fun lookupFriendships(vararg ids: Long): ResponseList<Friendship>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.lookupFriendships] */
    @Throws(TwitterException::class)
    suspend fun lookupFriendships(vararg screenNames: String): ResponseList<Friendship>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getIncomingFriendships] */
    @Throws(TwitterException::class)
    suspend fun getIncomingFriendships(cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getOutgoingFriendships] */
    @Throws(TwitterException::class)
    suspend fun getOutgoingFriendships(cursor: Long): IDs

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.createFriendship] */
    @Throws(TwitterException::class)
    suspend fun createFriendship(userId: Long): User

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.createFriendship] */
    @Throws(TwitterException::class)
    suspend fun createFriendship(screenName: String): User

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.createFriendship] */
    @Throws(TwitterException::class)
    suspend fun createFriendship(userId: Long, follow: Boolean): User

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.createFriendship] */
    @Throws(TwitterException::class)
    suspend fun createFriendship(screenName: String, follow: Boolean): User

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.destroyFriendship] */
    @Throws(TwitterException::class)
    suspend fun destroyFriendship(userId: Long): User

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.destroyFriendship] */
    @Throws(TwitterException::class)
    suspend fun destroyFriendship(screenName: String): User

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.updateFriendship] */
    @Throws(TwitterException::class)
    suspend fun updateFriendship(userId: Long, enableDeviceNotification: Boolean, retweets: Boolean): Relationship

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.updateFriendship] */
    @Throws(TwitterException::class)
    suspend fun updateFriendship(screenName: String, enableDeviceNotification: Boolean, retweets: Boolean): Relationship

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.showFriendship] */
    @Throws(TwitterException::class)
    suspend fun showFriendship(sourceId: Long, targetId: Long): Relationship

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.showFriendship] */
    @Throws(TwitterException::class)
    suspend fun showFriendship(sourceScreenName: String, targetScreenName: String): Relationship

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsList] */
    @Throws(TwitterException::class)
    suspend fun getFriendsList(userId: Long, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsList] */
    @Throws(TwitterException::class)
    suspend fun getFriendsList(userId: Long, cursor: Long, count: Int): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsList] */
    @Throws(TwitterException::class)
    suspend fun getFriendsList(screenName: String, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsList] */
    @Throws(TwitterException::class)
    suspend fun getFriendsList(screenName: String, cursor: Long, count: Int): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsList] */
    @Throws(TwitterException::class)
    suspend fun getFriendsList(
        userId: Long,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFriendsList] */
    @Throws(TwitterException::class)
    suspend fun getFriendsList(
        screenName: String,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersList] */
    @Throws(TwitterException::class)
    suspend fun getFollowersList(userId: Long, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersList] */
    @Throws(TwitterException::class)
    suspend fun getFollowersList(screenName: String, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersList] */
    @Throws(TwitterException::class)
    suspend fun getFollowersList(userId: Long, cursor: Long, count: Int): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersList] */
    @Throws(TwitterException::class)
    suspend fun getFollowersList(screenName: String, cursor: Long, count: Int): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersList] */
    @Throws(TwitterException::class)
    suspend fun getFollowersList(
        userId: Long,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.v1.FriendsFollowersResources.getFollowersList] */
    @Throws(TwitterException::class)
    suspend fun getFollowersList(
        screenName: String,
        cursor: Long,
        count: Int,
        skipStatus: Boolean,
        includeUserEntities: Boolean
    ): PagableResponseList<User>
}
