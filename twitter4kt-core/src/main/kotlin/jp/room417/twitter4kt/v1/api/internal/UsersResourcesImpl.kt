package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.UsersResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.*
import java.io.File
import java.io.InputStream

internal class UsersResourcesImpl(private val users: twitter4j.v1.UsersResources) : UsersResources {
    override suspend fun getAccountSettings(): AccountSettings = withContext(Dispatchers.IO) {
        users.accountSettings
    }

    override suspend fun verifyCredentials(): User = withContext(Dispatchers.IO) {
        users.verifyCredentials()
    }

    override suspend fun updateAccountSettings(
        trendLocationWoeid: Int,
        sleepTimeEnabled: Boolean,
        startSleepTime: String,
        endSleepTime: String,
        timeZone: String,
        lang: String
    ): AccountSettings = withContext(Dispatchers.IO) {
        users.updateAccountSettings(
            trendLocationWoeid,
            sleepTimeEnabled,
            startSleepTime,
            endSleepTime,
            timeZone,
            lang
        )
    }

    override suspend fun updateAllowDmsFrom(allowDmsFrom: String): AccountSettings = withContext(Dispatchers.IO) {
        users.updateAllowDmsFrom(allowDmsFrom)
    }

    override suspend fun updateProfile(name: String, url: String, location: String, description: String): User = withContext(Dispatchers.IO) {
        users.updateProfile(name, url, location, description)
    }

    override suspend fun updateProfileImage(image: File): User = withContext(Dispatchers.IO) {
        users.updateProfileImage(image)
    }

    override suspend fun updateProfileImage(image: InputStream): User = withContext(Dispatchers.IO) {
        users.updateProfileImage(image)
    }

    override suspend fun getBlocksList(): PagableResponseList<User> = withContext(Dispatchers.IO) {
        users.blocksList
    }

    override suspend fun getBlocksList(cursor: Long): PagableResponseList<User> = withContext(Dispatchers.IO) {
        users.getBlocksList(cursor)
    }

    override suspend fun getBlocksIDs(): IDs = withContext(Dispatchers.IO) {
        users.blocksIDs
    }

    override suspend fun getBlocksIDs(cursor: Long): IDs = withContext(Dispatchers.IO) {
        users.getBlocksIDs(cursor)
    }

    override suspend fun createBlock(userId: Long): User = withContext(Dispatchers.IO) {
        users.createBlock(userId)
    }

    override suspend fun createBlock(screenName: String): User = withContext(Dispatchers.IO) {
        users.createBlock(screenName)
    }

    override suspend fun destroyBlock(userId: Long): User = withContext(Dispatchers.IO) {
        users.destroyBlock(userId)
    }

    override suspend fun destroyBlock(screen_name: String): User = withContext(Dispatchers.IO) {
        users.destroyBlock(screen_name)
    }

    override suspend fun getMutesList(cursor: Long): PagableResponseList<User> = withContext(Dispatchers.IO) {
        users.getMutesList(cursor)
    }

    override suspend fun getMutesIDs(cursor: Long): IDs = withContext(Dispatchers.IO) {
        users.getMutesIDs(cursor)
    }

    override suspend fun createMute(userId: Long): User = withContext(Dispatchers.IO) {
        users.createMute(userId)
    }

    override suspend fun createMute(screenName: String): User = withContext(Dispatchers.IO) {
        users.createMute(screenName)
    }

    override suspend fun destroyMute(userId: Long): User = withContext(Dispatchers.IO) {
        users.destroyMute(userId)
    }

    override suspend fun destroyMute(screenName: String): User = withContext(Dispatchers.IO) {
        users.destroyMute(screenName)
    }

    override suspend fun lookupUsers(vararg ids: Long): ResponseList<User> = withContext(Dispatchers.IO) {
        users.lookupUsers(*ids)
    }

    override suspend fun lookupUsers(vararg screenNames: String): ResponseList<User> = withContext(Dispatchers.IO) {
        users.lookupUsers(*screenNames)
    }

    override suspend fun showUser(userId: Long): User = withContext(Dispatchers.IO) {
        users.showUser(userId)
    }

    override suspend fun showUser(screenName: String): User = withContext(Dispatchers.IO) {
        users.showUser(screenName)
    }

    override suspend fun searchUsers(query: String, page: Int): ResponseList<User> = withContext(Dispatchers.IO) {
        users.searchUsers(query, page)
    }

    override suspend fun getContributees(userId: Long): ResponseList<User> = withContext(Dispatchers.IO) {
        users.getContributees(userId)
    }

    override suspend fun getContributees(screenName: String): ResponseList<User> = withContext(Dispatchers.IO) {
        users.getContributees(screenName)
    }

    override suspend fun getContributors(userId: Long): ResponseList<User> = withContext(Dispatchers.IO) {
        users.getContributors(userId)
    }

    override suspend fun getContributors(screenName: String): ResponseList<User> = withContext(Dispatchers.IO) {
        users.getContributors(screenName)
    }

    override suspend fun removeProfileBanner() = withContext(Dispatchers.IO) {
        users.removeProfileBanner()
    }

    override suspend fun updateProfileBanner(image: File) = withContext(Dispatchers.IO) {
        users.updateProfileBanner(image)
    }

    override suspend fun updateProfileBanner(image: InputStream) = withContext(Dispatchers.IO) {
        users.updateProfileBanner(image)
    }
}
