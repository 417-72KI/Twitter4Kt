package jp.room417.twitter4kt.api.internal

import jp.room417.twitter4kt.api.FavoritesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.Paging
import twitter4j.ResponseList
import twitter4j.Status
import twitter4j.Twitter

internal class FavoritesResourcesImpl(private val twitter: Twitter) : FavoritesResources {
    override suspend fun getFavorites(): ResponseList<Status> = withContext(Dispatchers.IO) { twitter.favorites }

    override suspend fun getFavorites(userId: Long): ResponseList<Status> =
        withContext(Dispatchers.IO) { twitter.getFavorites(userId) }

    override suspend fun getFavorites(screenName: String): ResponseList<Status> =
        withContext(Dispatchers.IO) { twitter.getFavorites(screenName) }

    override suspend fun getFavorites(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) { twitter.getFavorites(paging) }

    override suspend fun getFavorites(userId: Long, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) { twitter.getFavorites(userId, paging) }

    override suspend fun getFavorites(screenName: String, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) { twitter.getFavorites(screenName, paging) }

    override suspend fun createFavorite(id: Long): Status = withContext(Dispatchers.IO) { twitter.createFavorite(id) }

    override suspend fun destroyFavorite(id: Long): Status = withContext(Dispatchers.IO) { twitter.destroyFavorite(id) }
}
