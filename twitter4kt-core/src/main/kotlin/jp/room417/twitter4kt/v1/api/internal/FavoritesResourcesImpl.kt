package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.FavoritesResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.Paging
import twitter4j.v1.ResponseList
import twitter4j.v1.Status

internal class FavoritesResourcesImpl(private val favorites: twitter4j.v1.FavoritesResources) : FavoritesResources {
    override suspend fun getFavorites(): ResponseList<Status> = withContext(Dispatchers.IO) { favorites.favorites }

    override suspend fun getFavorites(userId: Long): ResponseList<Status> =
        withContext(Dispatchers.IO) { favorites.getFavorites(userId) }

    override suspend fun getFavorites(screenName: String): ResponseList<Status> =
        withContext(Dispatchers.IO) { favorites.getFavorites(screenName) }

    override suspend fun getFavorites(paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) { favorites.getFavorites(paging) }

    override suspend fun getFavorites(userId: Long, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) { favorites.getFavorites(userId, paging) }

    override suspend fun getFavorites(screenName: String, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) { favorites.getFavorites(screenName, paging) }

    override suspend fun createFavorite(id: Long): Status = withContext(Dispatchers.IO) { favorites.createFavorite(id) }

    override suspend fun destroyFavorite(id: Long): Status =
        withContext(Dispatchers.IO) { favorites.destroyFavorite(id) }
}
