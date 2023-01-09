package jp.room417.twitter4kt.v1.api

import twitter4j.Paging
import twitter4j.ResponseList
import twitter4j.Status
import twitter4j.TwitterException

/** A wrapper of [twitter4j.api.FavoritesResources] */
interface FavoritesResources {
    /** A wrapper of [twitter4j.api.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(): ResponseList<Status>

    /** A wrapper of [twitter4j.api.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(userId: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.api.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(screenName: String): ResponseList<Status>

    /** A wrapper of [twitter4j.api.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(userId: Long, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(screenName: String, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.FavoritesResources.createFavorite] */
    @Throws(TwitterException::class)
    suspend fun createFavorite(id: Long): Status

    /** A wrapper of [twitter4j.api.FavoritesResources.destroyFavorite] */
    @Throws(TwitterException::class)
    suspend fun destroyFavorite(id: Long): Status
}
