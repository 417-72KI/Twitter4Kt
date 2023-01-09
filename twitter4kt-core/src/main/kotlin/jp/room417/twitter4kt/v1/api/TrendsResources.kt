package jp.room417.twitter4kt.v1.api

import twitter4j.*

/** A wrapper of [twitter4j.api.TrendsResources] */
interface TrendsResources {
    /** A wrapper of [twitter4j.api.TrendsResources.getPlaceTrends] */
    @Throws(TwitterException::class)
    suspend fun getPlaceTrends(woeid: Int): Trends

    /** A wrapper of [twitter4j.api.TrendsResources.getAvailableTrends] */
    @Throws(TwitterException::class)
    suspend fun getAvailableTrends(): ResponseList<Location>

    /** A wrapper of [twitter4j.api.TrendsResources.getClosestTrends] */
    @Throws(TwitterException::class)
    suspend fun getClosestTrends(location: GeoLocation): ResponseList<Location>
}
