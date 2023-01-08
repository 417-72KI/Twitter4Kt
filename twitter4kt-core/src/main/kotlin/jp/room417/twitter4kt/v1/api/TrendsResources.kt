package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.TrendsResources] */
interface TrendsResources {
    /** A wrapper of [twitter4j.v1.TrendsResources.getPlaceTrends] */
    @Throws(TwitterException::class)
    suspend fun getPlaceTrends(woeid: Int): Trends

    /** A wrapper of [twitter4j.v1.TrendsResources.getAvailableTrends] */
    @Throws(TwitterException::class)
    suspend fun getAvailableTrends(): ResponseList<Location>

    /** A wrapper of [twitter4j.v1.TrendsResources.getClosestTrends] */
    @Throws(TwitterException::class)
    suspend fun getClosestTrends(location: GeoLocation): ResponseList<Location>
}
