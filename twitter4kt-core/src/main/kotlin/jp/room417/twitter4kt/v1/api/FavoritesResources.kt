package jp.room417.twitter4kt.v1.api

import twitter4j.TwitterException
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.FavoritesResources] */
interface FavoritesResources {
    /** A wrapper of [twitter4j.v1.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(userId: Long): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(screenName: String): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(userId: Long, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.FavoritesResources.getFavorites] */
    @Throws(TwitterException::class)
    suspend fun getFavorites(screenName: String, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.v1.FavoritesResources.createFavorite] */
    @Throws(TwitterException::class)
    suspend fun createFavorite(id: Long): Status

    /** A wrapper of [twitter4j.v1.FavoritesResources.destroyFavorite] */
    @Throws(TwitterException::class)
    suspend fun destroyFavorite(id: Long): Status
}
