package jp.room417.twitter4kt.v1.api

import twitter4j.*
import java.io.File
import java.io.InputStream

/** A wrapper of [twitter4j.api.UsersResources] */
interface UsersResources {
    /** A wrapper of [twitter4j.api.UsersResources.getAccountSettings] */
    @Throws(TwitterException::class)
    suspend fun getAccountSettings(): AccountSettings

    /** A wrapper of [twitter4j.api.UsersResources.verifyCredentials] */
    @Throws(TwitterException::class)
    suspend fun verifyCredentials(): User

    /** A wrapper of [twitter4j.api.UsersResources.updateAccountSettings] */
    @Throws(TwitterException::class)
    suspend fun updateAccountSettings(
        trendLocationWoeid: Int,
        sleepTimeEnabled: Boolean,
        startSleepTime: String,
        endSleepTime: String,
        timeZone: String,
        lang: String
    ): AccountSettings

    /** A wrapper of [twitter4j.api.UsersResources.updateAllowDmsFrom] */
    @Throws(TwitterException::class)
    suspend fun updateAllowDmsFrom(allowDmsFrom: String): AccountSettings

    /** A wrapper of [twitter4j.api.UsersResources.updateProfile] */
    @Throws(TwitterException::class)
    suspend fun updateProfile(name: String, url: String, location: String, description: String): User

    /** A wrapper of [twitter4j.api.UsersResources.updateProfileBackgroundImage] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun updateProfileBackgroundImage(image: File, tile: Boolean): User

    /** A wrapper of [twitter4j.api.UsersResources.updateProfileBackgroundImage] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun updateProfileBackgroundImage(image: InputStream, tile: Boolean): User

    /** A wrapper of [twitter4j.api.UsersResources.updateProfileColors] */
    @Deprecated(message = "Will be removed on Twitter4J 4.1.0")
    @Throws(TwitterException::class)
    suspend fun updateProfileColors(
        profileBackgroundColor: String,
        profileTextColor: String,
        profileLinkColor: String,
        profileSidebarFillColor: String,
        profileSidebarBorderColor: String
    ): User

    /** A wrapper of [twitter4j.api.UsersResources.updateProfileImage] */
    @Throws(TwitterException::class)
    suspend fun updateProfileImage(image: File): User

    /** A wrapper of [twitter4j.api.UsersResources.updateProfileImage] */
    @Throws(TwitterException::class)
    suspend fun updateProfileImage(image: InputStream): User

    /** A wrapper of [twitter4j.api.UsersResources.getBlocksList] */
    @Throws(TwitterException::class)
    suspend fun getBlocksList(): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.getBlocksList] */
    @Throws(TwitterException::class)
    suspend fun getBlocksList(cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.getBlocksIDs] */
    @Throws(TwitterException::class)
    suspend fun getBlocksIDs(): IDs

    /** A wrapper of [twitter4j.api.UsersResources.getBlocksIDs] */
    @Throws(TwitterException::class)
    suspend fun getBlocksIDs(cursor: Long): IDs

    /** A wrapper of [twitter4j.api.UsersResources.createBlock] */
    @Throws(TwitterException::class)
    suspend fun createBlock(userId: Long): User

    /** A wrapper of [twitter4j.api.UsersResources.createBlock] */
    @Throws(TwitterException::class)
    suspend fun createBlock(screenName: String): User

    /** A wrapper of [twitter4j.api.UsersResources.destroyBlock] */
    @Throws(TwitterException::class)
    suspend fun destroyBlock(userId: Long): User

    /** A wrapper of [twitter4j.api.UsersResources.destroyBlock] */
    @Throws(TwitterException::class)
    suspend fun destroyBlock(screen_name: String): User

    /** A wrapper of [twitter4j.api.UsersResources.getMutesList] */
    @Throws(TwitterException::class)
    suspend fun getMutesList(cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.getMutesIDs] */
    @Throws(TwitterException::class)
    suspend fun getMutesIDs(cursor: Long): IDs

    /** A wrapper of [twitter4j.api.UsersResources.createMute] */
    @Throws(TwitterException::class)
    suspend fun createMute(userId: Long): User

    /** A wrapper of [twitter4j.api.UsersResources.createMute] */
    @Throws(TwitterException::class)
    suspend fun createMute(screenName: String): User

    /** A wrapper of [twitter4j.api.UsersResources.destroyMute] */
    @Throws(TwitterException::class)
    suspend fun destroyMute(userId: Long): User

    /** A wrapper of [twitter4j.api.UsersResources.destroyMute] */
    @Throws(TwitterException::class)
    suspend fun destroyMute(screenName: String): User

    /** A wrapper of [twitter4j.api.UsersResources.lookupUsers] */
    @Throws(TwitterException::class)
    suspend fun lookupUsers(vararg ids: Long): ResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.lookupUsers] */
    @Throws(TwitterException::class)
    suspend fun lookupUsers(vararg screenNames: String): ResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.showUser] */
    @Throws(TwitterException::class)
    suspend fun showUser(userId: Long): User

    /** A wrapper of [twitter4j.api.UsersResources.showUser] */
    @Throws(TwitterException::class)
    suspend fun showUser(screenName: String): User

    /** A wrapper of [twitter4j.api.UsersResources.searchUsers] */
    @Throws(TwitterException::class)
    suspend fun searchUsers(query: String, page: Int): ResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.getContributees] */
    @Throws(TwitterException::class)
    suspend fun getContributees(userId: Long): ResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.getContributees] */
    @Throws(TwitterException::class)
    suspend fun getContributees(screenName: String): ResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.getContributors] */
    @Throws(TwitterException::class)
    suspend fun getContributors(userId: Long): ResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.getContributors] */
    @Throws(TwitterException::class)
    suspend fun getContributors(screenName: String): ResponseList<User>

    /** A wrapper of [twitter4j.api.UsersResources.removeProfileBanner] */
    @Throws(TwitterException::class)
    suspend fun removeProfileBanner()

    /** A wrapper of [twitter4j.api.UsersResources.updateProfileBanner] */
    @Throws(TwitterException::class)
    suspend fun updateProfileBanner(image: File)

    /** A wrapper of [twitter4j.api.UsersResources.updateProfileBanner] */
    @Throws(TwitterException::class)
    suspend fun updateProfileBanner(image: InputStream)
}
