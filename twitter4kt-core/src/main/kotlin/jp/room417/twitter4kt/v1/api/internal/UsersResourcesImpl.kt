package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.UsersResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.*
import java.io.File
import java.io.InputStream

internal class UsersResourcesImpl(private val twitter: Twitter) : UsersResources {
    override suspend fun getAccountSettings(): AccountSettings = withContext(Dispatchers.IO) {
        twitter.accountSettings
    }

    override suspend fun verifyCredentials(): User = withContext(Dispatchers.IO) {
        twitter.verifyCredentials()
    }

    override suspend fun updateAccountSettings(
        trendLocationWoeid: Int,
        sleepTimeEnabled: Boolean,
        startSleepTime: String,
        endSleepTime: String,
        timeZone: String,
        lang: String
    ): AccountSettings = withContext(Dispatchers.IO) {
        twitter.updateAccountSettings(
            trendLocationWoeid,
            sleepTimeEnabled,
            startSleepTime,
            endSleepTime,
            timeZone,
            lang
        )
    }

    override suspend fun updateAllowDmsFrom(allowDmsFrom: String): AccountSettings = withContext(Dispatchers.IO) {
        twitter.updateAllowDmsFrom(allowDmsFrom)
    }

    override suspend fun updateProfile(name: String, url: String, location: String, description: String): User =
        withContext(Dispatchers.IO) {
            twitter.updateProfile(name, url, location, description)
        }

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember", "DEPRECATION")
    override suspend fun updateProfileBackgroundImage(image: File, tile: Boolean): User = withContext(Dispatchers.IO) {
        twitter.updateProfileBackgroundImage(image, tile)
    }

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember")
    override suspend fun updateProfileBackgroundImage(image: InputStream, tile: Boolean): User =
        withContext(Dispatchers.IO) {
            twitter.updateProfileBackgroundImage(image, tile)
        }

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember", "DEPRECATION")
    override suspend fun updateProfileColors(
        profileBackgroundColor: String,
        profileTextColor: String,
        profileLinkColor: String,
        profileSidebarFillColor: String,
        profileSidebarBorderColor: String
    ): User = withContext(Dispatchers.IO) {
        twitter.updateProfileColors(
            profileBackgroundColor,
            profileTextColor,
            profileLinkColor,
            profileSidebarFillColor,
            profileSidebarBorderColor
        )
    }

    override suspend fun updateProfileImage(image: File): User = withContext(Dispatchers.IO) {
        twitter.updateProfileImage(image)
    }

    override suspend fun updateProfileImage(image: InputStream): User = withContext(Dispatchers.IO) {
        twitter.updateProfileImage(image)
    }

    override suspend fun getBlocksList(): PagableResponseList<User> = withContext(Dispatchers.IO) {
        twitter.blocksList
    }

    override suspend fun getBlocksList(cursor: Long): PagableResponseList<User> = withContext(Dispatchers.IO) {
        twitter.getBlocksList(cursor)
    }

    override suspend fun getBlocksIDs(): IDs = withContext(Dispatchers.IO) {
        twitter.blocksIDs
    }

    override suspend fun getBlocksIDs(cursor: Long): IDs = withContext(Dispatchers.IO) {
        twitter.getBlocksIDs(cursor)
    }

    override suspend fun createBlock(userId: Long): User = withContext(Dispatchers.IO) {
        twitter.createBlock(userId)
    }

    override suspend fun createBlock(screenName: String): User = withContext(Dispatchers.IO) {
        twitter.createBlock(screenName)
    }

    override suspend fun destroyBlock(userId: Long): User = withContext(Dispatchers.IO) {
        twitter.destroyBlock(userId)
    }

    override suspend fun destroyBlock(screen_name: String): User = withContext(Dispatchers.IO) {
        twitter.destroyBlock(screen_name)
    }

    override suspend fun getMutesList(cursor: Long): PagableResponseList<User> = withContext(Dispatchers.IO) {
        twitter.getMutesList(cursor)
    }

    override suspend fun getMutesIDs(cursor: Long): IDs = withContext(Dispatchers.IO) {
        twitter.getMutesIDs(cursor)
    }

    override suspend fun createMute(userId: Long): User = withContext(Dispatchers.IO) {
        twitter.createMute(userId)
    }

    override suspend fun createMute(screenName: String): User = withContext(Dispatchers.IO) {
        twitter.createMute(screenName)
    }

    override suspend fun destroyMute(userId: Long): User = withContext(Dispatchers.IO) {
        twitter.destroyMute(userId)
    }

    override suspend fun destroyMute(screenName: String): User = withContext(Dispatchers.IO) {
        twitter.destroyMute(screenName)
    }

    override suspend fun lookupUsers(vararg ids: Long): ResponseList<User> = withContext(Dispatchers.IO) {
        twitter.lookupUsers(*ids)
    }

    override suspend fun lookupUsers(vararg screenNames: String): ResponseList<User> = withContext(Dispatchers.IO) {
        twitter.lookupUsers(*screenNames)
    }

    override suspend fun showUser(userId: Long): User = withContext(Dispatchers.IO) {
        twitter.showUser(userId)
    }

    override suspend fun showUser(screenName: String): User = withContext(Dispatchers.IO) {
        twitter.showUser(screenName)
    }

    override suspend fun searchUsers(query: String, page: Int): ResponseList<User> = withContext(Dispatchers.IO) {
        twitter.searchUsers(query, page)
    }

    override suspend fun getContributees(userId: Long): ResponseList<User> = withContext(Dispatchers.IO) {
        twitter.getContributees(userId)
    }

    override suspend fun getContributees(screenName: String): ResponseList<User> = withContext(Dispatchers.IO) {
        twitter.getContributees(screenName)
    }

    override suspend fun getContributors(userId: Long): ResponseList<User> = withContext(Dispatchers.IO) {
        twitter.getContributors(userId)
    }

    override suspend fun getContributors(screenName: String): ResponseList<User> = withContext(Dispatchers.IO) {
        twitter.getContributors(screenName)
    }

    override suspend fun removeProfileBanner() = withContext(Dispatchers.IO) {
        twitter.removeProfileBanner()
    }

    override suspend fun updateProfileBanner(image: File) = withContext(Dispatchers.IO) {
        twitter.updateProfileBanner(image)
    }

    override suspend fun updateProfileBanner(image: InputStream) = withContext(Dispatchers.IO) {
        twitter.updateProfileBanner(image)
    }
}
