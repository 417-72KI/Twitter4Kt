package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.TrendsResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.GeoLocation
import twitter4j.v1.Location
import twitter4j.v1.ResponseList
import twitter4j.v1.Trends

internal class TrendsResourcesImpl(private val trends: twitter4j.v1.TrendsResources) : TrendsResources {
    override suspend fun getPlaceTrends(woeid: Int): Trends = withContext(Dispatchers.IO) {
        trends.getPlaceTrends(woeid)
    }

    override suspend fun getAvailableTrends(): ResponseList<Location> = withContext(Dispatchers.IO) {
        trends.availableTrends
    }

    override suspend fun getClosestTrends(location: GeoLocation): ResponseList<Location> = withContext(Dispatchers.IO) {
        trends.getClosestTrends(location)
    }
}
